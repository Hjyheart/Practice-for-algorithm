package LeetCode;

import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/4/12.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LeetCodeLongestPalindromicSubstring_4 {

    public static String longestPalindrome_Manacher(String s) {
        if (s.length() < 2){
            return s;
        }
        ArrayList<Character> S = new ArrayList<>();
        S.add('#');
        for (char c : s.toCharArray()){
            S.add(c);
            S.add('#');
        }

        int[] P = new int[S.size()];
        int mx = 0;
        int id = 0;
        int max = -1;
        int pos = 0;
        for (int i = 0; i < S.size(); i++){
            P[i] = mx > i ? ((P[2 * id - i] < mx - i) ? P[2 * id - i] : mx - i) : 1;
            while ((i + P[i]) < S.size() && (i - P[i]) >=0 && S.get(i + P[i]) == S.get(i - P[i])){
                P[i] ++;
            }
            if (i + P[i] > mx){
                mx =  i + P[i];
                id = i;
            }
            if (max < P[i]){
                max = P[i];
                pos = i;
            }
        }

        String res = "";
        for (int i = pos - max + 1; i < pos + max; i++){
            if (S.get(i) != '#'){
                res += S.get(i);
            }
        }

        return res;
    }

    public static String longestPalindrome_regular(String s){
        if (s.length() < 2){
            return s;
        }

        int max = -1;
        int id = 0;
        for (int i = 0 ; i < s.length(); i++){
            int j = i, k = i;
            while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }

            if (max < k - j -1){
                max = k - j - 1;
                id = j + 1;
            }
        }

        for (int i = 0 ; i < s.length(); i++){
            int j = i, k = i + 1;
            while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }

            if (max < k - j -1){
                max = k - j - 1;
                id = j + 1;
            }
        }

        return s.substring(id, id + max);

    }



    public static void main(String [] args){
        longestPalindrome_Manacher("babad");
        System.out.println(longestPalindrome_regular("cbbd"));
    }
}
