package src;

/**
 * Created by I332329 on 11/30/2017.
 */
public class RangeSumQuery_303 {

    static class NumArray {
        int[] nums;
        int[][] dp;
        public NumArray(int[] nums) {
            this.nums = nums;
            this.dp = new int[nums.length][nums.length];
        }

        public int sumRange(int i, int j) {

            if (dp[i][j] != 0) {
                return dp[i][j];
            } else {
                for (int k = i; k <= j; k++) {
                    if (k == i) {
                        dp[i][k] = nums[i];
                        continue;
                    }
                    dp[i][k] = dp[i][k - 1] + nums[k];
                }
                return dp[i][j];
            }

        }
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
