import time

class Solution:
    def kMirror(self, k: int, n: int) -> int:
        ans = 0
        def check_mirror(num):
            i = 0
            j = len(num) - 1
            while i < j:
                if num[i] == num[j]:
                    i += 1
                    j -= 1
                else:
                    return False
            return True

        def generate_num_base(num, i, j):
            nonlocal ans
            nonlocal n
            if i == j:
                for c in range(10):
                    if i == 0 and c == 0:
                        continue
                    tmp = ''.join([num[:i], str(c), num[i+1:]])
                    if check_mirror(generate_num(int(tmp))):
                        ans += int(tmp)
                        n -= 1
                        if n == 0:
                            return
            elif i + 1 == j:
                for c in range(10):
                    if i == 0 and c == 0:
                        continue
                    tmp =''.join([num[:i], str(c), str(c), num[i+2:]])
                    if check_mirror(generate_num(int(tmp))):
                        ans += int(tmp)
                        n -= 1
                        if n == 0:
                            return
            else:
                for c in range(10):
                    if i == 0 and c == 0:
                        continue
                    tmp = ''.join([num[:i], str(c), num[i+1:j], str(c), num[j+1:]])
                    generate_num_base(tmp, i+1, j-1)
                    if n == 0:
                        return

        def generate_num(num_base):
            n = 0
            while k ** n <num_base:
                n += 1
            res = []
            f = False
            while n >= 0:
                t = num_base // (k ** n)
                if t > 0:
                    f = True
                    res.append(t)
                else:
                    if f:
                        res.append(0)
                num_base -= t * (k ** n)
                n -= 1
            return res

        num_base = '1'

        while n > 0:
            generate_num_base(num_base, 0, len(num_base) - 1)
            num_base = ''.join(["1"] + ["0"] * (max(0, len(num_base) - 1)) +  ["1"])

        return ans

if __name__ == '__main__':
    s = Solution()
    # print(s.kMirror(3, 7))
    print(s.kMirror(7, 30)) #241030621167