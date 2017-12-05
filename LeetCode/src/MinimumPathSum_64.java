package src;

/**
 * Created by hongjiayong on 2017/12/5.
 * Tag: DP
 * Solution:
 * 没啥好说的
 */
public class MinimumPathSum_64 {

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                if (i > 0) {
                    if (k > 0) {
                        dp[i][k] = Math.min(dp[i - 1][k], dp[i][k - 1]) + grid[i][k];
                    } else {
                        dp[i][k] = dp[i - 1][k] + grid[i][k];
                    }
                } else {
                    if (k > 0) {
                        dp[i][k] = dp[i][k - 1] + grid[i][k];
                    }
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
    }
}
