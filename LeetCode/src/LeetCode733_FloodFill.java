package src;

/**
 * Created by hongjiayong on 2017/12/21.
 * Tag: DFS
 */
public class LeetCode733_FloodFill {


    public static void dfs(int[][] image, int[][] visited, int x, int y, int newColor, int initColor) {
        image[x][y] = newColor;
        visited[x][y] = 1;

        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < 4; i++) {
            int X = x + dir[i][0];
            int Y = y + dir[i][1];

            if (X < 0 || Y < 0 || X >= image.length || Y >= image[0].length || visited[X][Y] == 1 || image[X][Y] != initColor) {
                continue;
            }

            dfs(image, visited, X, Y, newColor, initColor);
        }
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        int[][] visited = new int[m][n];

        visited[sr][sc] = 1;
        int initColor = image[sr][sc];
        image[sr][sc] = newColor;

        dfs(image, visited, sr, sc, newColor, initColor);

        return image;
    }

    public static void main(String[] args) {
        for (int[] line : floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2)) {
            for (int val : line) {
                System.out.print(val);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
