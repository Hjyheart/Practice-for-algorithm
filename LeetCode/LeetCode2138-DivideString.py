class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        ans = []
        idx = 0

        while idx < len(s):
            if idx + k < len(s):
                ans.append(s[idx:idx+k])
                idx += k
            else:
                tmp = [s[idx:]]
                for _ in range(k-len(tmp[0])):
                    tmp.append(fill)
                ans.append("".join(tmp))
                break
        return ans
