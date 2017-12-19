package src;

/**
 * Created by hongjiayong on 2017/12/19.
 * Tag: DP
 * Solution:
 * 2： 9 * 9 + 10
 * 3： 9 * 9 * 8 + 9 * 9 + 10
 */
public class CountNumberWithUniqueDigits_357 {

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }

        int count = 10;
        for (int i = 2; i <= n ; i++) {
            int k = i;
            int tmp = 9;
            int val = tmp;
            while (k >= 2) {
                if (k == i) {
                    val *= tmp;
                } else {
                    val *= (tmp-- - 1);
                }
                k--;
            }
            count += val;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
