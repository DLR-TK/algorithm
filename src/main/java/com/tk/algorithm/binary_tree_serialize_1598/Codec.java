package com.tk.algorithm.binary_tree_serialize_1598;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder res = new StringBuilder("[");
        if (root == null) {
            return "[]";
        } else {
            res.append(root.val).append(",");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                if (root.left != null) {
                    res.append(root.left.val).append(",");
                    queue.add(root.left);
                } else {
                    res.append("null,");
                }

                if (root.right != null) {
                    res.append(root.right.val).append(",");
                    queue.add(root.right);
                } else {
                    res.append("null,");
                }
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }

        String[] split = data.substring(1,data.length() - 1).split(",");
        Queue<String> dataQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        Collections.addAll(dataQueue, split);
        TreeNode head = getNode(dataQueue.poll());

        if (head != null) {
            queue.add(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = getNode(dataQueue.poll());
            node.right = getNode(dataQueue.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    public TreeNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        String s = new String("[1,2,3,null,null,4,5]");
    }

}
