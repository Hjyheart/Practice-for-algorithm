package src;

/**
 * Created by hongjiayong on 2017/12/15.
 * Tag: Tree
 * Solution:
 * Just for fun
 */
public class LeetCode26_InvertBinaryTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }

    public static void invert(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        TreeNode tmp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmp;
        invert(treeNode.left);
        invert(treeNode.right);
    }

    public static TreeNode invertTree(TreeNode root) {

        invert(root);

        return root;
    }

    public static void main(String[] args) {

    }
}
