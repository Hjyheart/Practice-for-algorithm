package src;

/**
 * Created by I332329 on 11/30/2017.
 * Tag: DP
 * Solution:
 * 没啥好说的 就是dp一下最小值
 */
public class LeetCode121_BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int max = 0;

        dp[0] = prices[0];
        for (int i = 1; i < dp.length; i++) {
            if(dp[i - 1] > prices[i]) {
                dp[i] = prices[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - dp[i] > max) {
                max = prices[i] - dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
