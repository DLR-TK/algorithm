package com.tk.algorithm.binary_tree_substructure_1585;

public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return process(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean process(TreeNode A, TreeNode B) {

        if(B == null)
            return true;
        if(A == null || A.val != B.val)
            return false;
        return process(A.left, B.left) && process(A.right, B.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
