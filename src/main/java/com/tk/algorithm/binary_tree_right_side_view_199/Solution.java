package com.tk.algorithm.binary_tree_right_side_view_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(node.val);
        }

        depth++;

        dfs(node.right, depth);
        dfs(node.left, depth);
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}