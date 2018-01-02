package src;

/**
 * Created by I332329 on 11/30/2017.
 * Tag: DP
 * Solution:
 * 没啥好说的
 */
public class LeetCode303_RangeSumQuery {

    static class NumArray {
        int[] nums;
        int[] dp;
        public NumArray(int[] nums) {
            this.nums = nums;
            this.dp = new int[nums.length];

            dp[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }

        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return dp[j];
            }
            return dp[j] - dp[i - 1];
        }
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
