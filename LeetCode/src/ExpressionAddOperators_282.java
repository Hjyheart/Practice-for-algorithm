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
//                System.out.println(tmp.toString());
                if (tmp.charAt(0) == '0' && tmp.length() > 1) {
                    return  -1;
                }
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
                while (!operations.isEmpty() && operations.peek() == '*') {
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

    public static void dfs(String str, int pos, String cur, int target, ArrayList<String> res) {
        String[] operations = new String[]{"+", "-", "*", ""};

        if (pos >= str.length()) {
            return;
        }

        cur += str.charAt(pos);
        if (calc(cur) == target) {
            res.add(cur);
        }

        for (String c : operations) {
            if (!c.equals("")) {
                dfs(str, pos + 1, cur + c, target, res);
            } else {
                dfs(str, pos + 1, cur, target, res);

            }
        }

    }


    public  static List<String> addOperators(String num, int target) {
        ArrayList<String> res = new ArrayList<>();

        dfs(num, 0, "", target, res);

        return res;
    }


    public static void main(String[] args) {
        System.out.println(calc("1+2+3+4+5-6*7-8*9"));
//        System.out.println(addOperators("123", 6));
//        System.out.println(addOperators("3456237490", 9191));
    }

}
