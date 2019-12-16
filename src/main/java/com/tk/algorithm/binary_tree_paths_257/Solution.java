package com.tk.algorithm.binary_tree_paths_257;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        if (root == null)
            return res;

        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> left = binaryTreePaths(root.left);
        for (int i = 0; i < left.size(); i++) {
            res.add(root.val + "->" + left.get(i));
        }

        List<String> right = binaryTreePaths(root.right);
        for (int i = 0; i < right.size(); i++) {
            res.add(root.val + "->" + right.get(i));
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
