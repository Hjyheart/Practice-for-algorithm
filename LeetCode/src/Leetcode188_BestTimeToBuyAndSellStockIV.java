package src;

import java.util.ArrayList;

/**
 * Created by hongjiayong on 19/01/2018.
 * Tag: DP
 * Solution:
 * 这道题想了很久 看了别人的解法 得以想通
 * 这个的解法和III是相似的 还是用Buy和Sell变量去模拟
 * 但是在K很大的情况下发现过不了 原因就是K很大的情况其实就是II的情况
 * 用现在的算法反而很没有效率 其实这道题就是把之前的II和III整合一下
 */
public class Leetcode188_BestTimeToBuyAndSellStockIV {

    static class BuyAndSell {

        public int buy;
        public int sell;

        public BuyAndSell() {
            buy = Integer.MIN_VALUE;
            sell = 0;
        }
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }

        if (prices.length < k) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                int dis = prices[i] - prices[i - 1];
                if (dis > 0) {
                    res += dis;
                }
            }
            return res;
        }

        ArrayList<BuyAndSell> ops = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            BuyAndSell tmp = new BuyAndSell();
            tmp.buy = -prices[0];
            ops.add(tmp);
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < ops.size(); j++) {
                if (j == 0) {
                    if (ops.get(j).buy < -prices[i]) {
                        ops.get(j).buy = -prices[i];
                    }
                    if (ops.get(j).sell < ops.get(j).buy + prices[i]) {
                        ops.get(j).sell = ops.get(j).buy + prices[i];
                    }
                } else {
                    if (ops.get(j).buy < ops.get(j - 1).sell - prices[i]) {
                        ops.get(j).buy = ops.get(j - 1).sell - prices[i];
                    }
                    if (ops.get(j).sell < ops.get(j).buy + prices[i]) {
                        ops.get(j).sell = ops.get(j).buy + prices[i];
                    }
                }
            }
        }
        return ops.get(ops.size() - 1).sell;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{1, 2, 3, 1, 2, 20, 3}));
        System.out.println(maxProfit(0, new int[]{1, 3}));
    }
}
