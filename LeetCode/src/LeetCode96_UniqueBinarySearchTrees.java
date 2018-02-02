package src;

/**
 * Created by hongjiayong on 03/02/2018.
 * Tag: DP
 * Solution:
 * 记忆型dfs
 * 从左子树要几个 右子树要几个来算
 */
public class LeetCode96_UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
