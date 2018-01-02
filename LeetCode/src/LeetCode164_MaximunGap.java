package src;

import java.util.ArrayList;

/**
 * Created by I332329 on 11/24/2017.
 * Solution:
 * 先遍历一遍得到最大值和最小值，然后得到平均gap=(max - min)/(n - 1)
 * 然后分桶，一个gap的在一个桶里，这样的话最大距离一定是相邻桶的间距，注意要跳过没有用的桶
 * 桶内维护一个最大值和最小值就行了
 * Tag: Sort
 */
public class LeetCode164_MaximunGap {
    public static class bucket{
        ArrayList<Integer> numbers;
        int max, min;
        boolean used;
        public bucket() {
            numbers = new ArrayList<>();
            max = -1;
            min = 999999999;
            used = false;
        }

        public void push(int item) {
            used = true;
            numbers.add(item);
            if (max < item) {
                max = item;
            }
            if (min > item) {
                min = item;
            }
        }
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = -1;
        int min = 999999999;
        ArrayList<bucket> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int gap = Math.max((max - min) / (nums.length - 1), 1);
        for (int i = 0; i <= (max - min) / gap; i++) {
            buckets.add(new bucket());
        }

        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / gap;
            buckets.get(index).push(nums[i]);
        }

        int pre = min;
        int maxGap = 0;
        for (bucket b : buckets) {
            if (!b.used){
                continue;
            }
            maxGap = Math.max(maxGap, b.min - pre);
            pre = b.max;
        }

        return maxGap;
    }

    public static void main(String[] args){
        System.out.println(maximumGap(new int[]{1,1,1,1,1,5,5,5,5,5}));
    }
}
