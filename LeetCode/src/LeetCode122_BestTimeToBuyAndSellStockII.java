package src;

/**
 * Created by hongjiayong on 12/01/2018.
 */
public class LeetCode122_BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            int dis = prices[i] - prices[i - 1];
            if (dis > 0) {
                res += dis;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}));
    }
}
