package src;

/**
 * Created by I332329 on 11/29/2017.
 */
public class LongestPalindromicSubstring_5 {


    public static String dpSolution(String s) {
        if (s.length() <= 1) {
            return s;
        }

        boolean dp[][] = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < s.length(); k++) {
                if (i == k || k == i - 1) {
                    dp[i][k] = true;
                } else {
                    dp[i][k] = false;
                }
            }
        }

        String maxString = s.substring(0, 1);

        int start = 0, end = 0;

        while (end < s.length()) {
            for (start = 0; start < end; start++) {
                if (dp[start][end]) {
                    if (end - start + 1 > maxString.length()) {
                        maxString = s.substring(start, end + 1);
                    }
                } else {
                    if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        if (end - start + 1 > maxString.length()) {
                            maxString = s.substring(start, end + 1);
                        }
                    }
                }
            }
            end++;
        }

        return maxString;
    }


    // Manacher算法
    public static String pre(String s) {
        char[] res = new char[2 * s.length() + 1];
        res[0] = '#';
        int k = 1;
        for (int i = 0; i < s.length(); i++, k++) {
            res[k] = s.charAt(i);
            k++;
            res[k] = '#';
        }
        return String.valueOf(res);
    }



    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String tmp = pre(s);

        int mx = 0, id = 0;
        int[] p = new int[tmp.length()];

        for (int i = 1; i < tmp.length() - 1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;

            while(i + p[i] < tmp.length() && i - p[i] >= 0 && tmp.charAt(i + p[i]) == tmp.charAt(i - p[i])) {
                p[i]++;
            }

            if(i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }

        int maxLen = 0, index = 0;
        for(int i = 1; i < tmp.length() - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                index = i;
            }
        }

        return s.substring((index - maxLen)/2 + 1, (index - maxLen)/2 + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
