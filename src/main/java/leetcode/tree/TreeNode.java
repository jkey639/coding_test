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

    // 추가 문제 풀이 연습
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // true example
        // TreeNode p = new TreeNode(1);
        // p.left = new TreeNode(2);
        // p.right = new TreeNode(3);
        // TreeNode q = new TreeNode(1);
        // q.left = new TreeNode(2);
        // q.right = new TreeNode(3);

        // false example
        // TreeNode p = new TreeNode(1);
        // p.left = new TreeNode(2);
        // TreeNode q = new TreeNode(1);
        // q.right = new TreeNode(2);

        // 풀이
        // p.val int vs q.val int
        // p.left = TreeNode vs q.left = TreeNode
        // p.right = TreeNode vs q.right = TreeNode
        // parameter로 받은 TreeNode를 left, right가 null 값을 반환할 때까지 재귀 수행
        return false;
    }
}
