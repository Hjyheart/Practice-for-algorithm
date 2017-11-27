package src;

import java.util.ArrayList;

/**
 * Created by I332329 on 11/21/2017.
 * Solution:
 * 这道题很有趣。算出中位数，然后把所有小于中位数的挨个放在奇数位，大于中位数的放在偶数位。
 * 中位数不动位置就行了
 * Tag: Sort
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
        int n = nums.length;
        int medium = findKth(nums, 0, n - 1, (n - 1) / 2);
        int left = 0, right = n - 1, i = 0;

        while (i <= right) {
            if (nums[newIndex(i, n)] > medium) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < medium) {
               swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    public static int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    public static void main(String[] args) {
        int[] tests = {5,3,1,2,6,7,8,5,5};
        wiggleSort(tests);
        for (int i : tests) {
            System.out.println(i);
        }
    }
}
