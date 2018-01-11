package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongjiayong on 11/01/2018.
 * Tag: Dfs
 * Solution:
 * 暴力然后优化存储提速就好了
 */
public class LeetCode464_CanIWin {

    public static boolean dfs(char[] state, Map<String, Boolean> map, int curRemain) {
        String key = new String(state);

        if (map.containsKey(key)) {
            return map.get(key);
        }

        for (int i = 0; i < state.length; i++) {
            if (state[i] == '0') {
                state[i] = '1';
                if (curRemain - (i + 1) <= 0 || !dfs(state, map, curRemain - i - 1)) {
                    map.put(key, true);
                    state[i] = '0';
                    return true;
                }
                state[i] = '0';
            }
        }

        map.put(key, false);
        return false;
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        char[] state = new char[maxChoosableInteger];
        Map<String, Boolean> map = new HashMap<>();

        Arrays.fill(state, '0');

        return dfs(state, map, desiredTotal);
    }

    public static void main(String[] args) {

        System.out.println(canIWin(4, 6));
    }
}
