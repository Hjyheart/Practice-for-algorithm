package src;

import java.util.Stack;

/**
 * Created by hongjiayong on 2017/12/5.
 * Tag: Stack
 * Solution:
 * 先压栈 遇到大的就出栈
 */
public class DailyTemperatures_739 {


    // Brute force
//    public static int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        res[res.length - 1] = 0;
//
//        for (int i = 0; i < res.length - 1; i++) {
//            for (int k = i + 1; k < res.length; k++) {
//                if (temperatures[k] > temperatures[i]) {
//                    res[i] = k - i;
//                    break;
//                }
//
//                if (k == res.length - 1) {
//                    res[i] = 0;
//                }
//            }
//        }
//
//        return res;
//    }

    // Stack
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        res[res.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});

        for (int item : res) {
            System.out.print(item + " ");
        }
    }
}
