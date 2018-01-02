package src;

import java.util.*;

/**
 * Created by hongjiayong on 2017/12/16.
 * Tag: BFS
 * Solution:
 * 转化成无向图 然后BFS
 */
public class LeetCode742_ClosestLeafInABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void pre(TreeNode node, TreeNode father, Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited, Map<Integer, Boolean> leaves) {
        ArrayList<Integer> tmp = new ArrayList<>();
        visited.put(node.val, true);
        if (node.left != null) {
            tmp.add(node.left.val);
            pre(node.left, node, map, visited, leaves);
        }
        if (node.right != null) {
            tmp.add(node.right.val);
            pre(node.right, node, map, visited, leaves);
        }
        if (father != null) {
            tmp.add(father.val);
        }

        if (node.left == null && node.right == null) {
            leaves.put(node.val, true);
        }

        map.put(node.val, tmp);
    }

    public static int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> leaves = new HashMap<>();

        pre(root, null, map, visited, leaves);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(k);
        visited.put(k, false);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            if (leaves.containsKey(tmp)) {
                return tmp;
            }
            ArrayList<Integer> tmpList = map.get(tmp);
            for (int i = 0; i < tmpList.size(); i++) {
                if (visited.get(tmpList.get(i))) {
                    queue.add(tmpList.get(i));
                    visited.put(tmpList.get(i), false);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.left.left.left = new TreeNode(5);
//        head.left.left.left.left = new TreeNode(6);
//        head.left = new TreeNode(3);
//        head.right = new TreeNode(2);
        System.out.println(findClosestLeaf(head, 1));
    }

}
