package src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by hongjiayong on 2017/11/20.
 */
public class LeetCode720_LongestWordInDictionary {

    static class wordComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            String str1 = (String) o1;
            String str2 = (String) o2;

            if (str1.length() == str2.length()) {
                return str1.compareTo(str2);
            } else {
                return str2.length() - str1.length();
            }
        }
    }


    public static String longestWord(String[] words) {

        HashMap map = new HashMap();

        for (String str : words) {
            if (!map.containsKey(str)) {
                map.put(str, true);
            }
        }

        Arrays.sort(words, new wordComparator());

        for (String str : words) {
            System.out.println(str);
        }

        for (String str : words) {
            for (int k = str.length(); k >= 1; k--) {
                if (!map.containsKey(str.substring(0, k))) {
                    System.out.println(str.substring(0, k));
                    break;
                }
                if (k == 1) {
                    return str;
                }
            }
        }

        return null;
    }

    public static void main (String [] args) {
        System.out.println(longestWord(new String[] {"mq", "mr", "abc", "m"}));
    }
}
