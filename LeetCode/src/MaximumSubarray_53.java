package src;

/**
 * Created by I332329 on 12/1/2017.
 * Tag: DP
 * Solution:
 * 就是开一个变量来存当前的和 如果大于max了就更新max 然后如果负了就置零重新加
 * 注释部分为怎么求位置的代码
 */
public class MaximumSubarray_53 {

    public static int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

//        int start = 0, end = 0, temp = 0;
        int subSum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            subSum += nums[i];
            if (subSum > max) {
                max = subSum;
//                start = temp;
//                end = i;
            }
            if (subSum < 0) {
                subSum = 0;
//                temp = i + 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

}
