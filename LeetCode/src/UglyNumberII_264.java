package src;

/**
 * Created by hongjiayong on 2017/11/29.
 * Tag: DP
 * Solution:
 * 这个题一开始一直在想怎么调整2 3 5的个数 后来发现根本不需要 你只需要记录乘 2 3 5的最小值就行了
 * 每次都取最小值 就解决了
 */
public class UglyNumberII_264 {

    public static int nthUglyNumber(int n) {

        int[] uglys = new int[1700];
        uglys[0] = 1;

        int valTwo = 2, valThree = 3, valFive = 5;
        int twoFlag = 0, threeFlag = 0, fiveFlag = 0;

        for (int i = 1; i < n; i++) {
            int base = Math.min(valTwo, Math.min(valThree, valFive));

            if (base == valTwo) {
                uglys[i] = valTwo;
                twoFlag++;
                valTwo = uglys[twoFlag] * 2;
            }
            if (base == valThree) {
                uglys[i] = valThree;
                threeFlag++;
                valThree = uglys[threeFlag] * 3;
            }
            if (base == valFive) {
                uglys[i] = valFive;
                fiveFlag++;
                valFive = uglys[fiveFlag] * 5;
            }
        }

        return uglys[n - 1];
    }

    public static void main(String[] args) {
        nthUglyNumber(18);
    }
}
