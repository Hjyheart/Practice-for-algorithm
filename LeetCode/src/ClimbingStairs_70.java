package src;

/**
 * Created by I332329 on 12/1/2017.
 * Tag: DP
 * Solution:
 * 没啥好说的
 */
public class ClimbingStairs_70 {

    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int dp[] = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] += dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
