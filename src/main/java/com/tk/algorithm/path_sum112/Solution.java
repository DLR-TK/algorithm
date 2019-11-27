package com.tk.algorithm.path_sum112;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
