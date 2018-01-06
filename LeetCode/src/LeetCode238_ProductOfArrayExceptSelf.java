package src;

/**
 * Created by hongjiayong on 06/01/2018.
 * 水
 */
public class LeetCode238_ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int all = 1, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                if (count > 1) {
                    return new int[nums.length];
                }
                continue;
            }
            all *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (count == 1) {
                if (nums[i] != 0) {
                    nums[i] = 0;
                    continue;
                } else {
                    nums[i] = all;
                    continue;
                }
            }
            nums[i] = all / nums[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        for (int t : productExceptSelf(new int[]{9, 0, -2})) {
            System.out.println(t);
        }
        System.out.println(" ");
    }

}
