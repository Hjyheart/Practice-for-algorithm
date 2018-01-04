package src;

import static java.lang.StrictMath.abs;

/**
 * Created by hongjiayong on 04/01/2018.
 * 数学题
 */
public class LeetCode754_ReachANumber {

    public static int reachNumber(int target) {

        target = abs(target);
        int res = 1, sum = 0;
        while (sum < target || (sum - target) % 2 == 1) {
            sum += res;
            res++;
        }
        return res - 1;
    }

    public static void main(String[] args) {
        System.out.println(reachNumber(100));
        System.out.println(reachNumber(2));
        System.out.println(reachNumber(1287466));
    }
}
