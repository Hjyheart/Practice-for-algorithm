package src;

/**
 * Created by hongjiayong on 07/01/2018.
 * Tag: 大数相乘
 */
public class LeetCode43_MultiplyStrings {

    public static String bigAdd(String num1, String num2) {
        int pos1 = num1.length() - 1, pos2 = num2.length() - 1, bonus = 0;

        StringBuilder res = new StringBuilder();
        while (pos1 >= 0 || pos2 >= 0) {
            int one = 0, two = 0;
            if (pos1 >= 0) {
                one = num1.charAt(pos1) - 48;
                pos1--;
            }
            if (pos2 >= 0) {
                two = num2.charAt(pos2) - 48;
                pos2--;
            }
            int tmp = one + two + bonus;
            bonus = tmp / 10;
            res.append(tmp % 10);
        }
        if (bonus != 0) {
            res.append(bonus);
        }
        res.reverse();
        return res.toString();
    }


    public static String multiply(String num1, String num2) {
        int bonus = 0;
        String prevSum = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int one = num1.charAt(i) - 48;
            StringBuilder re = new StringBuilder();
            for (int k = num2.length() - 1; k >= 0; k--) {
                int two = num2.charAt(k) - 48;
                int tmp = one * two + bonus;
                bonus = tmp / 10;
                re.append(tmp % 10);
            }
            if (bonus != 0) {
                re.append(bonus);
                bonus = 0;
            }
            re.reverse();
            int dis = num1.length() - 1 - i;
            while (dis > 0) {
                re.append('0');
                dis--;
            }
            prevSum = bigAdd(prevSum, re.toString());
        }

        return prevSum.charAt(0) == '0' ? "0" : prevSum;
    }

    public static void main(String[] args) {
        System.out.println(bigAdd("21", "19"));
        System.out.println(multiply("923", "29"));
    }
}
