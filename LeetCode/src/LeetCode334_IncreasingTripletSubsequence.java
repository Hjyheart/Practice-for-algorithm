package src;

/**
 * Created by hongjiayong on 2017/12/15.
 */
public class LeetCode334_IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= secMin) {
                secMin = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(increasingTriplet(new int[]{5,1,5,5,2,5,4}));
        System.out.println(increasingTriplet(new int[]{2,1,5,0,3}));
    }
}
