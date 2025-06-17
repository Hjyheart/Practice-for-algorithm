class Solution:
    def maximumDifference(self, nums: list[int]) -> int:
        max_diff = -1
        min_idx = 0

        for i in range(1, len(nums)):
            if nums[i] > nums[min_idx]:
                max_diff = max(max_diff, nums[i] - nums[min_idx])
            else:
                min_idx = i

        return max_diff


if __name__ == '__main__':
    s = Solution()
    print(s.maximumDifference([7,1,5,4]))
    print(s.maximumDifference([9,4,3,2]))
    print(s.maximumDifference([1,5,2,10]))
    print(s.maximumDifference([87,68,91,86,58,63,43,98,6,40]))