class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def count_prefix(prefix, n):
            curr = prefix
            next_ = prefix + 1
            count = 0
            while curr <= n:
                count += min(n + 1, next_) - curr
                curr *= 10
                next_ *= 10
            return count

        curr = 1
        k -= 1  # 从1开始算，跳过第一个
        while k > 0:
            count = count_prefix(curr, n)
            if k >= count:
                k -= count
                curr += 1
            else:
                k -= 1
                curr *= 10
        return curr

# [1, 10, 100, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 3, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 4, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 5, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 6, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 7, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 8, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 9, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]

if __name__ == '__main__':
    s = Solution()
    print(s.findKthNumber(1, 1))
    print(s.findKthNumber( 13, 2))
    print(s.findKthNumber(100, 8))
    print(s.findKthNumber(804289384, 42641503))