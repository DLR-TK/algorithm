package com.tk.algorithm.invert_binary_tree_226;

public class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        invertTree(root.left);
        invertTree(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
