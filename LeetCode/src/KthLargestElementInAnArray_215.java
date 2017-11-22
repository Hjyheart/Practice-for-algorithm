package src;

/**
 * Created by hongjiayong on 2017/11/22.
 */
public class KthLargestElementInAnArray_215 {

    public static void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
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

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
//        int[] nums = {3,1,2,4};
        System.out.println(findKth(nums, 0, nums.length - 1, 4));
    }
}
