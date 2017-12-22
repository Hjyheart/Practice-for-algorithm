package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hongjiayong on 2017/12/20.
 * Tag: DFS
 */
public class ExpressionAddOperators_282 {

    public static int calc(String str) {
        Stack<Character> operations = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int n = 0;
        StringBuilder tmp = new StringBuilder("");
        while (n < str.length()) {
            while (str.charAt(n) >= '0' && str.charAt(n) <= '9') {
                tmp.append(str.charAt(n));
                n++;
                if (n >= str.length()) {
                    break;
                }
                continue;
            }
            if (!tmp.toString().equals("")){
                nums.push(Integer.parseInt(tmp.toString()));
                tmp = new StringBuilder("");
            }
            if (n >= str.length()) {
                break;
            }
            if (operations.isEmpty()) {
                operations.push(str.charAt(n));
                n++;
                continue;
            }
            char op = operations.peek();
            if ((str.charAt(n) == '+' || str.charAt(n) == '-') && op == '*') {
                while (operations.peek() == '*') {
                    operations.pop();
                    int one = nums.pop();
                    int two = nums.pop();
                    nums.push(one * two);
                }
                operations.push(str.charAt(n));
            } else {
                operations.push(str.charAt(n));
            }
            n++;
        }

        while (!operations.isEmpty()) {
            char op = operations.pop();
            int one = nums.pop();
            int two = nums.pop();
            switch (op) {
                case '+':
                    nums.push(one + two);
                    break;
                case '-':
                    nums.push(two - one);
                    break;
                case '*':
                    nums.push(one * two);

            }
        }
        return nums.peek();
    }

//    public static String dfs(String str, int pos, String cur, int target, ArrayList<String> res) {
//        char[] operations = new char[]{'+', '-', '*', ' '};
//    }


    public  static List<String> addOperators(String num, int target) {
        ArrayList<String> res = new ArrayList<>();




        return res;
    }


    public static void main(String[] args) {
        System.out.println(addOperators("123", 6));
        System.out.println(calc("1+2*3-2"));
    }

}
