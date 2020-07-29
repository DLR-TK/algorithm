package com.tk.algorithm.binary_tree_lowest_ancestor_1745;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).lca;
    }

    public Info process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Info(null, false, false);
        }
        Info leftInfo = process(root.left, p, q);
        Info rightInfo = process(root.right, p, q);

        boolean findP = root == p || leftInfo.findP || rightInfo.findP;
        boolean findQ = root == q || leftInfo.findQ || rightInfo.findQ;

        TreeNode lca = null;
        if (leftInfo.lca != null) {
            lca = leftInfo.lca;
        }
        if (rightInfo.lca != null) {
            lca = rightInfo.lca;
        }
        if (lca == null) {
            if (findP && findQ) {
                lca = root;
            }
        }

        return new Info(lca, findP, findQ);
    }

    public class Info {
        TreeNode lca;
        boolean findP;
        boolean findQ;

        public Info(TreeNode lca, boolean findP, boolean findQ) {
            this.lca = lca;
            this.findP = findP;
            this.findQ = findQ;
        }
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
