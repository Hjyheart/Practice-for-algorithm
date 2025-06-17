class Solution:
    def maxDiff(self, num: int) -> int:
        num_str = str(num)
        max_num = -1
        min_num = 10**8 + 1
        idx = 0
        while idx < len(num_str) and (max_num == -1 or min_num == 10 ** 8 + 1):
            min_change_label = 1 if idx == 0 else 0
            change_ch = num_str[idx]
            if max_num == -1 and change_ch != '9':
                max_num = int(num_str.replace(change_ch, '9'))
            while min_num == 10**8 + 1 and change_ch != str(min_change_label):
                if idx > 0 and change_ch == num_str[0]:
                    min_num = int(num_str.replace(change_ch, num_str[0]))
                else:
                    min_num = int(num_str.replace(change_ch, str(min_change_label)))
                if min_num == num:
                    min_change_label += 1
                    min_num = 10 ** 8 + 1
                    break
                if min_num == 0:
                    min_change_label += 1
                    min_num = 10**8 + 1

            idx += 1

        if max_num == -1:
            max_num = num
        if min_num == 10**8 + 1:
            min_num = num

        return max_num - min_num

if __name__ == '__main__':
    s = Solution()
    print(s.maxDiff(555))
    print(s.maxDiff(9))
    print(s.maxDiff(123456))
    print(s.maxDiff(10000))
    print(s.maxDiff(1101057))