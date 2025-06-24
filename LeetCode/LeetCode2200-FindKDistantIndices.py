class Solution:
    def findKDistantIndices(self, nums: list[int], key: int, k: int) -> list[int]:
        ans = []
        low = 0
        high = 0
        for idx, val in enumerate(nums):
            if val == key:
                low = max(high, idx - k)
                high = min(idx + k, len(nums) - 1)
                for c in range(low, high + 1):
                    if c not in ans:
                        ans.append(c)
                if high == len(nums) - 1:
                    break
        return ans
