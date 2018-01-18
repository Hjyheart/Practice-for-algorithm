package src;

/**
 * Created by hongjiayong on 18/01/2018.
 * Tag: DP
 * Solution:
 * 这道题其实挺简单的 就是四个变量记录一下第一次买卖和第二次买卖
 * 可以从左到右刷一遍 从右到左刷一遍 然后求最大
 * 也可以直接四个变量一次过
 * 不过还是挺trick的
 */
public class LeetCode123_BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int i = 0; i < prices.length; i++) {
            if (firstBuy < -prices[i]) {
                firstBuy = -prices[i];
            }
            if (firstSell < firstBuy + prices[i]) {
                firstSell = firstBuy + prices[i];
            }
            if (secondBuy < firstSell - prices[i]) {
                secondBuy = firstSell - prices[i];
            }
            if (secondSell < secondBuy + prices[i]) {
                secondSell = secondBuy + prices[i];
            }
        }

        return secondSell;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 1, 2, 20, 3}));
    }
}
