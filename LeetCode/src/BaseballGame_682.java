package src;

import java.util.Stack;

/**
 * Created by I332329 on 11/27/2017.
 * Tag: Stack
 */
public class BaseballGame_682 {
    public static int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> scores = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int tmp = scores.pop();
                    int newScore = tmp + scores.peek();
                    res += newScore;
                    scores.push(tmp);
                    scores.push(newScore);
                    break;
                case "C":
                    res -= scores.pop();
                    break;
                case "D":
                    scores.push(2 * scores.peek());
                    res += scores.peek();
                    break;
                default:
                    int num = Integer.valueOf(op);
                    scores.push(num);
                    res += num;
            }
        }
        return res;
    }
    public static void main (String[] args) {
        calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
    }
}
