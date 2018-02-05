package src;

/**
 * Created by hongjiayong on 05/02/2018.
 */
public class LeetCode650_2KeysKeyboard {

    public static int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] copyAll = new int[n];
        int[] paste = new int[n];

        copyAll[0] = 1;
        copyAll[1] = 1;
        paste[1] = 1;

        for (int i = 2; i < n; i++) {
            if ((n - paste[i - 1]) % paste[i - 1] == 0) {
                copyAll[i] = paste[i - 1];
                if (copyAll[i] == copyAll[i - 1]) {
                    paste[i] = paste[i - 1] + copyAll[i];
                    if (paste[i] == n) {
                        return i;
                    }
                } else {
                    paste[i] = paste[i - 1];
                }
            } else {
                copyAll[i] = copyAll[i - 1];
                paste[i] = paste[i - 1] + copyAll[i];
                if (paste[i] == n) {
                    return i;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100000; i++) {
            System.out.println(minSteps(i));
        }
    }

}
