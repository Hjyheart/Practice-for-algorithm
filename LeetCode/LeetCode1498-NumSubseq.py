import bisect

class Solution:
    def numSubseq(self, nums: list[int], target: int) -> int:
        mod = 10 ** 9 + 7
        ans = 0
        nums.sort()
        for i, n in enumerate(nums):
            if 2 * n > target:
                break
            j = bisect.bisect(nums, target - n, lo=i)
            ans += pow(2, j - i - 1, mod)
        return ans % mod