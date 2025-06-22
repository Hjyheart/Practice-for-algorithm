class Solution:
    def romanToInt(self, s: str) -> int:
        val_m = {
            "I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000,
        }
        cur = 0
        ans = 0
        while cur < len(s):
            val = 0
            if s[cur] in ["I", "X", "C"]:
                if cur + 1 < len(s):
                    if s[cur] == "I" and s[cur + 1] == "V":
                        val = 4
                        cur += 1
                    elif s[cur] == "I" and s[cur + 1] == "X":
                        val = 9
                        cur += 1
                    elif s[cur] == "X" and s[cur + 1] == "L":
                        val = 40
                        cur += 1
                    elif s[cur] == "X" and s[cur + 1] == "C":
                        val = 90
                        cur += 1
                    elif s[cur] == "C" and s[cur + 1] == "D":
                        val = 400
                        cur += 1
                    elif s[cur] == "C" and s[cur + 1] == "M":
                        val = 900
                        cur += 1
                    else:
                        val = val_m[s[cur]]
                else:
                    val = val_m[s[cur]]
            else:
                val = val_m[s[cur]]
            ans += val
            cur += 1
        return ans

if __name__ == '__main__':
    s = Solution()
    print(s.romanToInt("LVIII"))