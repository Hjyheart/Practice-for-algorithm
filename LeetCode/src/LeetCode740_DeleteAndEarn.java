package src;

/**
 * Created by hongjiayong on 2017/12/4.
 * Tag: DP
 * Solution:
 * 这个题很神奇 一开始想得太复杂了 一直在想怎么把状态保存下来 但是其实并不是这么复杂的
 * 考虑到同一个数重复的话一直选择都不会消除它本身 所以某一个数的值可以先数一下看总和是多少
 * 然后从头开始 跟那道抢商店差不多 dp[i - 1]选了 就没有dp[i] 所以只需要看dp[i - 2]和本身的和是不是大于dp[i - 1]就好了
 */
public class LeetCode740_DeleteAndEarn {
//    递归版本
//    public static ArrayList<Integer> clean(ArrayList<Integer> nums, int deleteItem) {
//        ArrayList<Integer> newNums = new ArrayList<>();
//        ArrayList<Integer> tmp = (ArrayList<Integer>) nums.clone();
//        tmp.remove(tmp.indexOf(deleteItem));
//        for (int i = 0; i < tmp.size(); i++) {
//            if (tmp.get(i) == deleteItem - 1 || tmp.get(i) == deleteItem + 1) {
//                continue;
//            }
//            newNums.add(tmp.get(i));
//        }
//
//        return newNums;
//    }
//
//    public static int findMax(ArrayList<Integer> nums, int[] dp, int currentScore) {
//        if (nums.size() == 0) {
//            return currentScore;
//        }
//
//        int sum = 0;
//        for (int i = 0; i < nums.size(); i++) {
//            sum += nums.get(i);
//        }
//
//        sum += nums.size() * nums.get(nums.size() / 2);
//
//        if (dp[sum] != 0) {
//            return dp[sum];
//        }
//
//        int max = -1;
//
//        for (int i = 0; i < nums.size(); i++) {
//            int deleteItem = nums.get(i);
//            int tmp = currentScore;
//            tmp = Math.max(findMax(clean(nums, deleteItem), dp, tmp + deleteItem), tmp);
//            if (tmp > max) {
//                max = tmp;
//            }
//        }
//
//        currentScore = max;
//        dp[sum] = max;
//        return currentScore;
//    }

    public static int deleteAndEarn(int[] nums) {

        int [] dp = new int[10001];
        int [] pre = new int[10001];


        for (int i = 0; i < nums.length; i++) {
            pre[nums[i]] += nums[i];
        }

        dp[0] = pre[0];
        dp[1] = Math.max(pre[1], dp[0]);

        if (nums.length < 2) {
            return dp[nums.length];
        }

        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(pre[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[10000];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(deleteAndEarn(new int[]{8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4}));
    }

}
