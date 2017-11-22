package LeetCode;

/**
 * Created by hongjiayong on 2017/4/10.
 * For LeetCode @3 Longest Substring Without Repeating Characters
 * Description:
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LeetCodeLongestSubstringWithoutRepeatingCharacters_3 {

    public static int lengthOfLongestSubstring(String s){

        if (s.length() <= 1){
            return s.length();
        }

        int maxLen = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()){
            for (int i = start; i < end; i++){
                if (s.charAt(i) == s.charAt(end)){
                    maxLen = (end - start > maxLen) ? end - start : maxLen;
                    start = i + 1;
                    break;
                }
            }
            end ++;
        }

        maxLen = (end - start > maxLen) ? end - start : maxLen;
        return maxLen;
    }

    public static void main(String [] args){
        int res = lengthOfLongestSubstring("au");
        System.out.println(res);
    }
}
