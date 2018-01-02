package src;

/**
 * Created by hongjiayong on 2017/12/6.
 * Tag: easy
 */
public class LeetCode598_RangeAdditionII {

    public static int maxCount(int m, int n, int[][] ops) {
        int minWidth = n;
        int minHeight = m;

        for (int i = 0; i < ops.length; i++) {
            int width = ops[i][1];
            int height = ops[i][0];

            minWidth = Math.min(width, minWidth);
            minHeight = Math.min(height, minHeight);
        }


        return minWidth * minHeight;
    }

    public static void main(String[] args) {
        System.out.println(maxCount(3, 3, new int[][] {{2, 2}, {3, 3}}));
    }
}
