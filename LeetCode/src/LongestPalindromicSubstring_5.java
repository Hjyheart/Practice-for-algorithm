package src;

/**
 * Created by I332329 on 11/29/2017.
 */
public class LongestPalindromicSubstring_5 {

    public static boolean vertify(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
//        if (s.length() <= 1) {
//            return s;
//        }
        int start = 0, end = 0;
        String maxString = "";
        while (end <= s.length()) {
            for (int i = end; i >= 0; i--) {
                if (2 * end - i >= s.length()) {
                    if (s.substring(i + 1, 2 * end - i).length() > maxString.length()) {
                        maxString = s.substring(i + 1, 2 * end - i);
                    }
                    break;
                }
                if (s.charAt(i) != s.charAt(2 * end - i)) {
                    if (s.substring(i + 1, 2 * end - i).length() > maxString.length()) {
                        maxString = s.substring(i + 1, 2 * end - i);
                    }
                    break;
                }
            }
            end++;
        }
        return maxString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
