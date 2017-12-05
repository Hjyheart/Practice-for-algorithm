package src;

/**
 * Created by hongjiayong on 2017/12/5.
 */
public class CherryPick_741 {

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int[][] location = new int[n][m];

        for (int i = 0; i < location.length; i++) {
            for (int k = 0; k <location[0].length; k++) {
                location[i][k] = -1;
            }
        }

        dp[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (grid[i][k] == -1) {
                    continue;
                }
                if (i > 0) {
                    if (k > 0) {
                        if (grid[i - 1][k] == -1 && grid[i][k - 1] == -1) {
                            continue;
                        } else if(grid[i - 1][k] == -1) {
                            dp[i][k] = dp[i][k - 1] + grid[i][k];
                            location[i][k] = 1;
                        } else if(grid[i][k - 1] == -1) {
                            dp[i][k] = dp[i - 1][k] + grid[i][k];
                            location[i][k] = 2;
                        } else {
                            dp[i][k] = Math.max(dp[i - 1][k], dp[i][k - 1]) + grid[i][k];
                            location[i][k] = dp[i - 1][k] > dp[i][k - 1] ? 2 : 1;
                        }
                    } else {
                        if(grid[i - 1][k] == -1) {
                            continue;
                        }
                        dp[i][k] = dp[i - 1][k] + grid[i][k];
                        location[i][k] = 2;
                    }
                } else {
                    if (k > 0) {
                        if(grid[i][k - 1] == -1) {
                            continue;
                        }
                        dp[i][k] = dp[i][k - 1] + grid[i][k];
                        location[i][k] = 1;
                    }
                }
            }
        }

        int res1 = dp[n - 1][m - 1];

        int flag = location[n - 1][m - 1], xId = n - 1, yId = m - 1;
        while (flag != -1) {
            grid[xId][yId] = 0;
            if (flag == 2) {
                xId--;
            } else {
                yId--;
            }
            flag = location[xId][yId];
        }

        if (xId != 0 || yId != 0) {
            return 0;
        }
        grid[0][0] = 0;
        dp =new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int k = m - 1; k >= 0; k--) {
                if (grid[i][k] == -1) {
                    continue;
                }
                if (i < n - 1) {
                    if (k < m - 1) {
                        if (grid[i + 1][k] == -1 && grid[i][k + 1] == -1) {
                            continue;
                        } else if(grid[i + 1][k] == -1) {
                            dp[i][k] = dp[i][k + 1] + grid[i][k];
                        } else if(grid[i][k + 1] == -1) {
                            dp[i][k] = dp[i + 1][k] + grid[i][k];
                        } else {
                            dp[i][k] = Math.max(dp[i + 1][k], dp[i][k + 1]) + grid[i][k];
                        }
                    } else {
                        if(grid[i + 1][k] == -1) {
                            continue;
                        }
                        dp[i][k] = dp[i + 1][k] + grid[i][k];
                    }
                } else {
                    if (k < m - 1) {
                        if(grid[i][k + 1] == -1) {
                            continue;
                        }
                        dp[i][k] = dp[i][k + 1] + grid[i][k];
                    }
                }
            }
        }

        return res1 + dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}));
    }

}
