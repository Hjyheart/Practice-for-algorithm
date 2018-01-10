package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongjiayong on 10/01/2018.
 * Tag: Tree
 * Solution:
 * 递归一下
 */
public class LeetCode508_MostFrequentSubtreeSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int solve(Map<Integer, Integer> times, TreeNode node) {
        if (node.left == null && node.right == null) {
            if (times.containsKey(node.val)) {
                times.put(node.val, times.get(node.val) + 1);
            } else {
                times.put(node.val, 1);
            }
            return node.val;
        }
        int sum = 0;
        if (node.left == null) {
            sum = solve(times, node.right) + node.val;
        } else if (node.right == null) {
            sum = solve(times, node.left) + node.val;
        } else {
            sum = solve(times, node.right) + solve(times, node.left) + node.val;
        }

        if (times.containsKey(sum)) {
            times.put(sum, times.get(sum) + 1);
        } else {
            times.put(sum, 1);
        }

        return sum;
    }

    public static int[] findFrequentTreeSum(TreeNode root) {

        if (root == null) {
            return new int[]{};
        }

        Map<Integer, Integer> times = new HashMap<>();

        solve(times, root);

        int max = -1;

        for (Integer key : times.keySet()) {
            if (times.get(key) > max) {
                max = times.get(key);
            }
        }

        ArrayList<Integer> tmp = new ArrayList<>();

        for (Integer key : times.keySet()) {
            if (times.get(key) == max) {
                tmp.add(key);
            }
        }

        int[] res = new int[tmp.size()];


        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }

        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-5);

        root.left = left;
        root.right = right;

        for (int num : findFrequentTreeSum(root)) {
            System.out.println(num);
        }
    }

}
