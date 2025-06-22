class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        ans = []
        nums.sort()
        i = 0
        while i < len(nums) - 1:
            while i > 0 and i < len(nums) - 1 and nums[i] == nums[i - 1]:
                i += 1

            j = i + 1
            k = len(nums) - 1
            first_num = nums[i]

            while j < k:
                total = first_num + nums[j] + nums[k]
                if total == 0:
                    ans.append([first_num, nums[j], nums[k]])
                    j += 1
                    while nums[j] == nums[j - 1] and j < k:
                        j += 1
                elif total < 0:
                    j += 1
                else:
                    k -= 1

            i += 1

        return ans

if __name__ == '__main__':
    s = Solution()
    print(s.threeSum([-1,0,1,2,-1,-4])) #[[-1,-1,2],[-1,0,1]]
