class Solution:
    def minimizeMax(self, nums: list[int], p: int) -> int:
        nums.sort()
        n = len(nums)

        def pair_cnt(thre):
            cnt = 0
            idx = 0
            while idx < n - 1:
                if nums[idx + 1] - nums[idx] <= thre:
                    cnt += 1
                    idx += 1
                idx += 1
            return cnt

        left = 0
        right = nums[-1] - nums[0]

        while left < right:
            mid = left + (right - left) // 2
            if pair_cnt(mid) >= p:
                right = mid
            else:
                left = mid + 1

        return left

if __name__ == '__main__':
    s = Solution()
    print(s.minimizeMax([10,1,2,7,1,3], 2))