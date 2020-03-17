package com.tk.algorithm.diameter_of_binary_tree_543;

public class Solution {

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return res;
    }

    private int depth(TreeNode treeNode) {

        if (treeNode == null)
            return 0;
        int left = depth(treeNode.left);
        int right = depth(treeNode.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
