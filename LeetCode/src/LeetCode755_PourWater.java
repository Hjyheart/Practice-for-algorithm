package src;

/**
 * Created by hongjiayong on 04/01/2018.
 * Tag: Array
 * Solution:
 * 贼简单一道题会做成这样 唉
 */
public class LeetCode755_PourWater {

    public static int[] pourWater(int[] heights, int V, int K) {

        if (V == 0) {
            return heights;
        }

        while (V > 0) {
            V--;
            int tmp = K;
            for (int k = K - 1; k >= 0; k--) {
                if (heights[k] > heights[tmp]) {
                    break;
                } else if (heights[k] < heights[tmp]) {
                    tmp = k;
                }
            }
            if (tmp == K) {
                for (int k = K + 1; k < heights.length; k++) {
                    if (heights[k] > heights[tmp]) {
                        break;
                    } else if (heights[k] < heights[tmp]) {
                        tmp = k;
                    }
                }
            }
            heights[tmp]++;
        }

        return heights;
    }

    public static void main(String[] args) {
        for (int item : pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3)) {
            System.out.println(item);
        }
        System.out.println(' ');
        for (int item : pourWater(new int[]{1, 2, 3, 4}, 2, 2)) {
            System.out.println(item);
        }
        System.out.println(' ');
        for (int item : pourWater(new int[]{3, 1, 3}, 5, 1)) {
            System.out.println(item);
        }
        System.out.println(' ');
        for (int item : pourWater(new int[]{14,10,10,3,13,1,2,1,2,5}, 1, 0)) {
            System.out.println(item);
        }
        System.out.println(' ');
        for (int item : pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1}, 5, 5)) {
            System.out.println(item);
        }
    }
}
