package src;

/**
 * Created by hongjiayong on 14/01/2018.
 * Tag：DP
 * Solution:
 * 122基础上加一个cool数组记录冷却的状态
 */
public class LeetCode309_BestTimeToBuyAndSellStockWithCoolDown {

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] hold = new int[prices.length];
        int[] skip = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] cool = new int[prices.length];

        buy[0] = 0 - prices[0];
        hold[0] = 0 - prices[0];
        cool[0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(cool[i - 1], skip[i - 1]) - prices[i];
            hold[i] = Math.max(buy[i - 1], hold[i - 1]);
            skip[i] = Math.max(cool[i - 1], skip[i - 1]);
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i];
            cool[i] = sell[i - 1];
        }

        int max = Math.max(buy[prices.length - 1], hold[prices.length - 1]);
        max = Math.max(max, skip[prices.length - 1]);
        max = Math.max(max, sell[prices.length - 1]);
        max = Math.max(max, cool[prices.length - 1]);

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 4}));
    }
}
