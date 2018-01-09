package src;

/**
 * Created by hongjiayong on 09/01/2018.
 * Tag: Greedy
 * solution:
 * 只关心前两跳
 */
public class LeetCode45_JumpNumberII {

    public static int jump(int[] nums) {
        int range = 1; // 第1跳能及的最远范围
        int next = 0; // 第2跳能及的最远范围
        int i = 1;
        int count = 0;

        while (range < nums.length) {
            if (i <= range) {
                next = Math.max(next, i + nums[i - 1]);
                i++;
            }
            else {
                count++;
                range = next;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }

}
