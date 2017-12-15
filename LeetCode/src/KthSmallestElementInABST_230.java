package src;

import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/12/15.
 * Tag: BST
 */
public class KthSmallestElementInABST_230 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public static void find(TreeNode node, ArrayList<Integer> list, int k) {
        if (list.size() == k) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        if (node.left != null) {
            find(node.left, list, k);
        }

        list.add(node.val);

        if (node.right != null) {
            find(node.right, list, k);
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        find(root, res, k);

        return res.get(k - 1);
    }


    public static void main(String[] args) {

    }

}
