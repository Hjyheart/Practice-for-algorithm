package src;

/**
 * Created by I332329 on 11/28/2017.
 * Tag: String
 * Solution:
 * 找规律就行了 跟波很像 就同一个周期里距离是相等的 但是要单独处理第一行和最后一行两点重合的情况
 * 不使用字符串直接拼接 这样会拖慢速度
 */
public class LeetCode6_ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        int sum = (numRows - 1) * 2;
        int disOne = 0, disTwo = 0;
        boolean flag = true;
        int length = s.length();
        int point = 0;
        char[] res = new char[length];

        int j = 0;
        while (j < length) {
            res[point++] = s.charAt(j);
            j += sum;
        }

        for (int i = 1; i < numRows - 1; i++) {
            int k = i;
            disOne = sum - 2 * i;
            disTwo = 2 * i;
            flag = true;
            while (k < length) {
                res[point++] = s.charAt(k);
                if (flag) {
                    k += disOne;
                } else {
                    k += disTwo;
                }
                flag = !flag;
            }
        }

        j = numRows - 1;
        while (j < length) {
            res[point++] = s.charAt(j);
            j += sum;
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
}
