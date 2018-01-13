package src;

/**
 * Created by hongjiayong on 12/01/2018.
 * Tag: DP
 * Solution:
 * 这道题我不会 看的题解
 * 用buy hold skip 和 sell四个数组记录所有状态
 * 所有操作都只和上一步操作有关 相当于遍历了所有情况
 */
public class LeetCode714_BestTimeToBuyAndSellStockWithTransactionFee {

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] hold = new int[prices.length];
        int[] skip = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = buy[0] - prices[0];
        hold[0] = hold[0] - prices[0];

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(skip[i - 1], sell[i - 1]) - prices[i];
            hold[i] = Math.max(buy[i - 1], hold[i - 1]);
            skip[i] = Math.max(skip[i - 1], sell[i - 1]);
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i] - fee;
        }

        int max = Math.max(buy[prices.length - 1], hold[prices.length - 1]);
        max = Math.max(max, skip[prices.length - 1]);
        max = Math.max(max, sell[prices.length - 1]);

        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

}
