class Solution:
    def maxDifference(self, s: str, k: int) -> int:
        def getStatus(cnt_a: int, cnt_b: int) -> int:
            return ((cnt_a & 1) << 1) | (cnt_b & 1)

        n = len(s)
        ans = float("-inf")  # 最终最大差值

        for a in ["0", "1", "2", "3", "4"]:
            for b in ["0", "1", "2", "3", "4"]:
                if a == b:
                    continue  # 忽略相同字符

                # 初始化 best[状态]：记录每种奇偶状态下的最小 (cnt_a - cnt_b)
                best = [float("inf")] * 4
                cnt_a = cnt_b = 0  # 当前窗口中 a 和 b 的个数
                prev_a = prev_b = 0  # 左窗口左边（不含）a、b 的累计个数
                left = -1  # 左窗口边界

                # 右边界从 0 开始滑动
                for right in range(n):
                    cnt_a += (s[right] == a)
                    cnt_b += (s[right] == b)

                    # 保证窗口长度至少为 k，且 b 至少出现两次（才可能出现偶数频率）
                    while right - left >= k and cnt_b - prev_b >= 2:
                        # 当前左窗口状态（不含 s[left+1]）
                        left_status = getStatus(prev_a, prev_b)
                        # 更新该状态下最小差值
                        best[left_status] = min(
                            best[left_status], prev_a - prev_b
                        )
                        # 向右收缩窗口
                        left += 1
                        prev_a += (s[left] == a)
                        prev_b += (s[left] == b)

                    # 当前窗口状态
                    right_status = getStatus(cnt_a, cnt_b)
                    # 只在 right_status 为 10（a 奇 b 偶）时才可能更新答案
                    # 我们找的是 “以前出现过的 a 偶 b 偶” 状态（00）的差值，所以 ^0b10
                    if best[right_status ^ 0b10] != float("inf"):
                        ans = max(
                            ans, cnt_a - cnt_b - best[right_status ^ 0b10]
                        )

        return ans
