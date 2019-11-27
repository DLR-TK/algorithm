package com.tk.algorithm.level_order_traversal102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("all")
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.remove();

                list.add(node.val);

                if ( node.left != null) {
                    queue.add(node.left);
                }
                if ( node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
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
