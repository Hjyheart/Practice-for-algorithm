package src;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by I332329 on 12/1/2017.
 * Tag: Others
 */
public class LeetCode268_MissingNumber {

    public static int missingNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {3, 0, 1}));
    }
}
