package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongjiayong on 2017/12/5.
 */
public class LeetCode741_CherryPick {

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int[][] res = new int[m][m];
        for (int[] arr : res) {
            Arrays.fill(arr, - 1);
        }
        res[0][0] = 0;

        for (int i = 0; i < m; i++) {
            int [][] line = new int[m][m];
            for (int[] arr : line) {
                Arrays.fill(arr, -1);
            }
            for (int left = 0; left < m; left++) {
                for (int right = left; right < m; right++) {
                    int leftCount = res[left][right];
                    if (res[left][right] > - 1) {
                        for (int j = left; j < m && grid[i][j] > -1; j++) {
                            leftCount += grid[i][j];
                            if (j >= right) {
                                line[j][j] = Math.max(line[j][j], leftCount);
                            }
                            int rightCount = leftCount;
                            for (int k = Math.max(j + 1, right); k < m && grid[i][k] > -1; k++) {
                                rightCount += grid[i][k];
                                line[j][k] = Math.max(line[j][k], rightCount);
                            }
                        }
                    }
                }
            }
            res = line;
        }

        return Math.max(res[m - 1][m - 1], 0);
    }


    public static void main(String[] args) {
//        System.out.println(cherryPickup(new int[][]{{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}));
        System.out.println(cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));
    }

}
