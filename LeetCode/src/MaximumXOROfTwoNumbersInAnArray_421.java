package src;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by I332329 on 12/13/2017.
 * Tag: Bit
 * Solution:
 * 这个题不会 遍历每一位 运用a^b = c ->a^c=b,b^c=a的性质一位一位推测过去
 */
public class MaximumXOROfTwoNumbersInAnArray_421 {

    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
