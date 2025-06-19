class Solution:
    def partitionArray(self, nums: list[int], k: int) -> int:
        nums.sort()
        ans = 1
        p = 0
        idx = 1
        while idx < len(nums):
            if nums[idx] - nums[p] > k:
                p = idx
                ans += 1
            idx += 1

        return ans



if __name__ == '__main__':
    s = Solution()
    # print(s.partitionArray([3, 6, 1, 2, 5], 2))
    # print(s.partitionArray([1, 2, 3], 1))
    print(s.partitionArray([2, 2, 4, 5], 0))