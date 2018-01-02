package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongjiayong on 2017/12/15.
 * Tag: string
 */
public class LeetCode17_LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {

        Map<Character, char[]> map = new HashMap<>();

        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            char[] contents = map.get(digits.charAt(i));
            if (strings.isEmpty()) {
                for (int j = 0; j < contents.length; j++) {
                    StringBuilder newStr = new StringBuilder("");
                    newStr.append(contents[j]);
                    strings.add(newStr.toString());
                }
                continue;
            }
            ArrayList<String> tmpStrings = new ArrayList<>();
            for (int k = 0; k < strings.size(); k++) {
                String tmp = strings.get(k);
                for (int j = 0; j < contents.length; j++) {
                    StringBuilder newStr = new StringBuilder(tmp);
                    newStr.append(contents[j]);
                    tmpStrings.add(newStr.toString());
                }
            }
            strings = tmpStrings;
        }


        return strings;
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("278");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
