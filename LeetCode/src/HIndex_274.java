package src;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by I332329 on 11/24/2017.
 */
public class HIndex_274 {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) {
                return citations.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        hIndex(new int[]{100});
    }
}
