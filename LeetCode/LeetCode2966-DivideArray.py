class Solution:
    def divideArray(self, nums: list[int], k: int) -> list[list[int]]:
        nums.sort()
        result = []
        for i in range(0, len(nums), 3):
            if nums[i+2] - nums[i] > k:
                return []
            result.append([nums[i], nums[i+1], nums[i+2]])

        return result


if __name__ == '__main__':
    s = Solution()
    print(s.divideArray([1,3,4,8,7,9,3,5,1], 2))
    print(s.divideArray([2,4,2,2,5,2], 2))
    print(s.divideArray([4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], 14))