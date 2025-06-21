class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        ans = 0
        ds = [("N", "W"), ("N", "E"), ("S", "E"), ("S", "W")]
        for d1, d2 in ds:
            cur = 0
            r = k
            for d in s:
                if d == d1 or d == d2:
                    cur += 1
                elif r > 0:
                    cur += 1
                    r -= 1
                else:
                    cur -= 1
                ans = max(ans, cur)
        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.maxDistance("WEWE", 1))
    print(s.maxDistance("NW", 2))
    print(s.maxDistance("NWSE", 1))
    print(s.maxDistance("NSWWEW", 3))
    print(s.maxDistance("ENNSW", 1))