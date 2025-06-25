import bisect

class Solution:
    def kthSmallestProduct(self, nums1: list[int], nums2: list[int], k: int) -> int:
        left = -10**10
        right = 10**10

        def count(val, x1):
            if x1 > 0:
                return bisect.bisect_right(nums2, val // x1)
            elif x1 < 0:
                return len(nums2) - bisect.bisect_left(nums2, -(-val // x1))
            else:
                return len(nums2) if val >= 0 else 0

        while left <= right:
            mid = (left + right) // 2
            cnt = 0
            for num in nums1:
                cnt += count(mid, num)
            if cnt < k:
                left = mid + 1
            else:
                right = mid - 1

        return left


if __name__ == '__main__':
    s = Solution()
    print(s.kthSmallestProduct([-6], [-9], 1))  # 54
    print(s.kthSmallestProduct([2, 5], [3, 4], 2))  # 8
    print(s.kthSmallestProduct([-2,-1,0,1,2], [-3,-1,2,4,5], 3)) # -6