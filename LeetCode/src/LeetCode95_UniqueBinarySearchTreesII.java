package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjiayong on 03/02/2018.
 * Tag: DFS
 * Solution:
 * 原本以为要做dp 但是其实dfs就可以了 有点麻烦的这道题
 */
public class LeetCode95_UniqueBinarySearchTreesII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> lefts = dfs(start, i - 1);
            ArrayList<TreeNode> rights = dfs(i + 1, end);
            for (int k = 0; k < lefts.size(); k++) {
                for (int j = 0; j < rights.size(); j++) {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(k);
                    root.right = rights.get(j);
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        res = dfs(1, n);
        return res;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }
}
