class Solution:
    def maxDifference(self, s: str) -> int:
        cnt_m = {}
        pq = []
        for ch in s:
            if ch not in cnt_m:
                cnt_m[ch] = 0
            cnt_m[ch] += 1

        for _, val in cnt_m.items():
            pq.append(val)

        pq.sort()

        odd = None
        even = None
        for val in pq:
            if not even and val % 2 == 0:
                even = val
            if val % 2 != 0:
                odd = val

        return odd - even

if __name__ == '__main__':
    s = Solution()
    print(s.maxDifference("tzt"))