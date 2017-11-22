package src;

import java.util.ArrayList;

/**
 * Created by I332329 on 11/21/2017.
 */
public class WiggleSort_324 {

    public static void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public static int findKth(int[] nums, int p, int q, int k) {
        int m = (p + q) / 2;
        swap(nums, m, q);

        int point = p;
        for (int i = p; i < q; i++) {
            if (nums[i] < nums[q]) {
                swap(nums, i, point);
                point++;
            }
        }
        swap(nums, q, point);
        if (k == point - p) {
            return nums[point];
        }

        if (point - p < k) {
            return findKth(nums, point + 1, q, k - point + p - 1);
        } else {
            return findKth(nums, p, point - 1, k);
        }
    }

    public static void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int[] res = new int[nums.length];
        int medium = findKth(nums, 0, nums.length - 1, (nums.length - 1) / 2);
        int mediumCount = -1;
        int indexOdd = 0;
        int indexEven = 1;
        res[0] = medium;
        if (nums.length % 2 == 0) {
            mediumCount--;
            res[nums.length - 1] = medium;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < medium) {
                res[indexEven * 2] = nums[i];
                indexEven++;
            } else if (nums[i] > medium) {
                res[indexOdd * 2 + 1] = nums[i];
                indexOdd++;
            } else {
                if (mediumCount < 0) {
                    mediumCount++;
                } else {
                    mediumCount++;
                    int temp = res[mediumCount * 2];
                    res[mediumCount * 2] = medium;
                    res[indexEven * 2] = temp;
                    indexEven++;
                }
            }
        }
        nums = res;
    }

    public static int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    public static boolean vertify(int [] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
           if (i % 2 == 0) {
               if (i == 0 && nums[i] > nums[i + 1]) {
                   return false;
               }
               if (i == 0) {
                   continue;
               }
               if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                   return false;
               }
               if (i == nums.length - 1) {
                   continue;
               }
               if (nums[i] > nums[i - 1] || nums[i] > nums[i + 1]) {
                   return false;
               }
           } else {
               if (i == nums.length - 1 && nums[i] < nums[i - 1]) {
                   return false;
               }
               if (i == nums.length - 1) {
                   continue;
               }
               if (nums[i] < nums[i - 1] || nums[i] < nums[i + 1]) {
                   return false;
               }
           }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tests = {5,3,1,2,6,7,8,5,5};
        wiggleSort(tests);
        for (int i : tests) {
            System.out.println(i);
        }
    }
}
