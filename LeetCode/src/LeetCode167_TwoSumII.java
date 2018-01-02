package src;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by I332329 on 12/12/2017.
 */
public class LeetCode167_TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], new int[]{i + 1, 1});
            } else {
                int index = map.get(numbers[i])[0];
                map.put(numbers[i], new int[]{index, map.get(numbers[i])[1] + 1});
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]) && target - numbers[i] != numbers[i]) {
                res[0] = map.get(numbers[i])[0];
                res[1] = map.get(target - numbers[i])[0];
                return res;
            } else if (map.containsKey(target - numbers[i]) && target - numbers[i] == numbers[i]) {
                if (map.get(numbers[i])[1] > 1) {
                    res[0] = map.get(numbers[i])[0];
                    res[1] = res[0] + 1;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : twoSum(new int[]{0, 0, 3, 4}, 0)) {
            System.out.println(i);
        }
    }
}
