class Solution:
    def maxAdjacentDistance(self, nums: list[int]) -> int:
        max_val = -1
        for i in range(len(nums) - 1):
            max_val = max(max_val, abs(nums[i] - nums[i+1]))
        max_val = max(max_val, abs(nums[0] - nums[-1]))

        return max_val
