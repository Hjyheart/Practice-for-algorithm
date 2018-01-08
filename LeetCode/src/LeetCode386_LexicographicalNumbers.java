package src;

import java.util.*;

/**
 * Created by hongjiayong on 08/01/2018.
 */
public class LeetCode386_LexicographicalNumbers {

    static class compare implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            MyNum one = (MyNum) o1;
            MyNum two = (MyNum) o2;

            return one.value - two.value;
        }
    }

    static class MyNum{

        int num;
        int value;

        public MyNum(int n) {
            this.num = n;
            this.value = this.calcValue(String.valueOf(num));
        }

        private int calcValue(String num) {
            int n = num.length();
            int val = 0;
            int base = 10000000;

            for (int i = 0; i < num.length(); i++) {
                val += base * (num.charAt(i) - 48);
                base /= 10;
            }

            return val;
        }
    }



    public static List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<MyNum> myNums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            myNums.add(new MyNum(i));
        }

        myNums.sort(new compare());

        for (int i = 0; i < myNums.size(); i++) {
            res.add(myNums.get(i).num);
        }

        return res;
    }

    public static void main(String[] args) {
        for (Integer num : lexicalOrder(49999)) {
            System.out.println(num);
        }
    }
}
