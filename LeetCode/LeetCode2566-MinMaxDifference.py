class Solution:
    def minMaxDifference(self, num: int) -> int:
        num_str = str(num)
        max_val = -1
        min_val = 10 ** 8 + 1

        idx = 0
        while idx < len(num_str) and (max_val == -1 or min_val == 10 ** 8 + 1):
            ch_change = num_str[idx]
            if num_str[idx] != '9':
                if max_val == -1:
                    max_val = int(num_str.replace(ch_change, '9'))
            if min_val == 10 ** 8 + 1:
                min_val = int(num_str.replace(ch_change, '0'))
            idx += 1

        if max_val == -1:
            max_val = num
        if min_val == 10 ** 8 + 1:
            min_val = num

        return max_val - min_val