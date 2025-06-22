class Solution:
    def intToRoman(self, num: int) -> str:
        level_l = ["I", "V", "X", "L", "C", "D", "M"]
        check_l = [1000, 100, 10, 1]
        ans = []

        for idx in range(len(check_l)):
            t = num // check_l[idx]
            if t > 0:
                if t <= 3:
                    for _ in range(t):
                        ans.append(level_l[-1 - idx * 2])
                elif t == 4:
                    ans.append(level_l[-1 - idx * 2])
                    ans.append(level_l[- idx * 2])
                elif t == 9:
                    ans.append(level_l[-1 - idx * 2])
                    ans.append(level_l[1 - idx * 2])
                else:
                    ans.append(level_l[- idx * 2])
                    for _ in range(t - 5):
                        ans.append(level_l[-1 - idx * 2])
                num -= t * check_l[idx]
            else:
                continue

        return ''.join(ans)

if __name__ == '__main__':
    s = Solution()
    print(s.intToRoman(3749)) #"MMMDCCXLIX"
    print(s.intToRoman(1994)) #"MCMXCIV"