package src;

/**
 * Created by hongjiayong on 2017/12/15.
 * Tag: DFS
 */
public class LeetCode695_MaxAreaOfIsland {

    public static int dfs(int[][] grid, int[][] flag, int x, int y, int count) {
        if (flag[x][y] == 1 || grid[x][y] == 0) {
            return count;
        }

        flag[x][y] = 1;
        count++;

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int tmpX = x;
            int tmpY = y;
            tmpX += directions[i][0];
            tmpY += directions[i][1];
            if (tmpX < 0 || tmpY < 0 || tmpX > grid.length - 1 || tmpY > grid[0].length - 1) {
                continue;
            }
            count += dfs(grid, flag, tmpX, tmpY, 0);
        }

        return count;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] flag = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (flag[i][k] == 0) {
                    max = Math.max(dfs(grid, flag, i, k, 0), max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
        System.out.println(maxAreaOfIsland(new int[][]{{0,1},{1,1}}));
    }
}
