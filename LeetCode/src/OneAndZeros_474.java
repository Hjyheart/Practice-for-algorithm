package src;

import java.util.ArrayList;

/**
 * Created by I332329 on 12/4/2017.
 * Tag:DP
 * Solution:
 * 0-1背包问题 价值1 体积二维 满足m和n 很简单
 */
public class OneAndZeros_474 {

    public static int findMaxForm(String[] strs, int m, int n) {

        ArrayList<int[]> pre = new ArrayList<>();
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int zero = 0, one = 0;
            for (int k = 0; k < strs[i].length(); k++) {
                if (strs[i].charAt(k) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            pre.add(new int[]{zero, one});
        }

        for (int i = 1; i <= pre.size(); i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (pre.get(i - 1)[0] <= j && pre.get(i - 1)[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - pre.get(i - 1)[0]][k - pre.get(i - 1)[1]] + 1, dp[i - 1][j][k]);
                    } else {
                        dp[i][j][k] = dp[i -  1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[] {"10","0001","111001","1","0"}, 5, 3));
        System.out.println(findMaxForm(new String[] {"10","0","1"}, 1, 1));
        System.out.println(findMaxForm(new String[] {"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90, 66));
        System.out.println(findMaxForm(new String[] {"10","0001","111001","1","0"}, 4, 3));
        System.out.println(findMaxForm(new String[] {"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"}, 44, 39));
        System.out.println(findMaxForm(new String[] {"0111000","010101","111","000010","01101","0","1","01","1010","00","1111","001","111000","011","10","1101001111"}, 9, 80));
    }

}
