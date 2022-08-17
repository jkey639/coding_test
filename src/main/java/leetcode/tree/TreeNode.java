package leetcode.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        // 1 - 2 - 4 - ...
        // 경우의 수 1 : left, 경우의 수 2 : right >> 재귀
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        return recur(root, 0);
    }

    private int recur(TreeNode root, int nDepth) {

        return root == null ? nDepth : Math.max(recur(root.left, nDepth + 1), recur(root.right, nDepth + 1));
    }
}
