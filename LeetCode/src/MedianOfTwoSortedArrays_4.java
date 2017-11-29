package src;

import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/4/11.
 * Description:
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, k = 0;
        int count = 0;
        int res1 = 0;
        int res2 = 0;
        int flag = (nums1.length + nums2.length) / 2;
        boolean odd;
        if ((nums1.length + nums2.length) % 2 == 0){
            odd = true;
        }else {
            odd = false;
        }
        while (i != nums1.length || k != nums2.length){
            int num1 = (i < nums1.length) ? nums1[i] : 999999999;
            int num2 = (k < nums2.length) ? nums2[k] : 999999999;
            if (num1 < num2){
                res.add(num1);
                i++;
                count++;
            }else{
                res.add(num2);
                k++;
                count++;
            }

            if (odd){
                if (count == flag){
                    res1 = res.get(count - 1);
                }
                if (count == flag + 1){
                    res2 = res.get(count - 1);
                    return (res1 + res2) / 2.0;
                }
            }else{
                if (count == flag + 1){
                    return res.get(count - 1);
                }
            }
        }
        return 1.0;
    }

    public static void main(String [] args){
        int[] num1 = new int[]{};
        int[] num2 = new int[]{1};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
