package src;

/**
 * Created by hongjiayong on 02/01/2018.
 * Tag: other
 */
public class LeetCode289_GameOfLife {

    public static int checkRound(int[][] board, int x, int y) {
        int [][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}};
        int count = 0;

        for (int i = 0; i < dir.length; i++) {
            int X = x + dir[i][0];
            int Y = y + dir[i][1];

            if (X < 0 || Y < 0 || X >= board.length || Y >= board[0].length) {
                continue;
            }

            if (board[X][Y] == 1) {
                count++;
            }
        }

        return count;
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                int count = checkRound(board, i, k);
                if (board[i][k] == 1) {
                    if (count == 2 || count == 3) {
                        res[i][k] = 1;
                    } else {
                        res[i][k] = 0;
                    }
                } else {
                    if (count == 3) {
                        res[i][k] = 1;
                    } else {
                        res[i][k] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                board[i][k] = res[i][k];
            }
        }
    }

    public static void main(String[] args) {
        gameOfLife(new int[][]{{1}, {2}});
    }
}
