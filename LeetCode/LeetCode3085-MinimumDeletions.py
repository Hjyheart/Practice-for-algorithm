class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        cnt_m = {}
        ans = 10 ** 5 + 1
        for w in word:
            if w not in cnt_m:
                cnt_m[w] = 0
            cnt_m[w] += 1

        freqs = [val for _, val in cnt_m.items()]
        freqs.sort()

        for base in freqs:
            cur = 0
            for freq in freqs:
                if freq > base + k:
                    cur += freq - base - k
                elif freq < base:
                    cur += freq
            ans = min(ans, cur)
        return ans

if __name__ == '__main__':
    s = Solution()
    # print(s.minimumDeletions("aabcaba", 0))
    print(s.minimumDeletions("dabdcbdcdcd", 2))
