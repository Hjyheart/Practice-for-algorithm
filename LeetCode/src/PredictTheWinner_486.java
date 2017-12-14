package src;

/**
 * Created by I332329 on 12/13/2017.
 * Tag: DP
 * Solution:
 * 用dp[i][j]存序列的选最左边的最大值和选右边的最大值 然后
 * dp[i][j].rightMax = nums[i] + sum[i, j] - dp[i][j - 1].max
 * dp[i][j].leftMax = nums[i] + sum[i + 1， j] - dp[i + 1][j].max
 * rightMax从左向右 leftMax从右向左 元素为2的先初始化好就ok了
 */
public class PredictTheWinner_486 {

    static class dpCell{
        int leftMax;
        int rightMax;
        int max;

        public dpCell() {
            this.leftMax = 0;
            this.rightMax = 0;
            this.max = 0;
        }
    }

    public static boolean PredictTheWinner(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int n = nums.length;
        int sum[][] = new int[n][n];
        dpCell[][] dp = new dpCell[n][n];

        for (int i = 0; i < n - 1; i++) {
            for (int k = i; k < n; k++) {
                if (i == k) {
                    sum[i][i] = nums[i];
                    continue;
                }
                sum[i][k] = sum[i][k - 1] + nums[k];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                dp[i][k] = new dpCell();
                if (i == k) {
                    dp[i][k].leftMax = nums[i];
                    dp[i][k].rightMax = nums[i];
                    dp[i][k].max = nums[i];
                } else if (k == i + 1) {
                    dp[i][k].leftMax = nums[i];
                    dp[i][k].rightMax = nums[k];
                    dp[i][k].max = Math.max(nums[i], nums[k]);
                }
            }
        }

        for (int i = 2; i < n; i++) {
            dp[0][i].rightMax = sum[0][i - 1] - dp[0][i - 1].max + nums[i];

            int j = i - 2;

            while (j >= 1) {
                if (dp[j][i].max == 0) {
                    dp[j][i].rightMax = nums[i] + sum[j][i - 1] - dp[j][i - 1].max;
                    dp[j][i].leftMax = nums[j] + sum[j + 1][i] - dp[j + 1][i].max;
                    dp[j][i].max = Math.max(dp[j][i].rightMax, dp[j][i].leftMax);
                }
                j--;
            }

            dp[0][i].leftMax = nums[0] + sum[1][i] - dp[1][i].max;
            dp[0][i].max = Math.max(dp[0][i].rightMax, dp[0][i].leftMax);
        }

        if (dp[0][n - 1].max >= sum[0][n - 1] - dp[0][n - 1].max) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(PredictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(PredictTheWinner(new int[]{1, 2, 3, 4, 999, 3}));
    }
}
