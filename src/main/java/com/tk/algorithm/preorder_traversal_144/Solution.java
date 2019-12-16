package com.tk.algorithm.preorder_traversal_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("all")
public class Solution {

    /**
     * 速度最快 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        preorderTraversalAdd(root, res);
        return res;
    }

    public void preorderTraversalAdd(TreeNode root, List<Integer> res) {

        if (root == null) {
            return ;
        }
        res.add(root.val);
        if (root != null) {
            preorderTraversalAdd(root.left, res);
            preorderTraversalAdd(root.right, res);
        }
    }

    /**
     * 模拟命令栈 思路最清晰 速度最慢
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {

            Command command = stack.peek();
            stack.pop();

            if (command.s == "print") {
                res.add(command.node.val);
            }else {
                assert (command.s == "go");

                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    public class Command {
        String s;
        TreeNode node;
        Command(String string, TreeNode treeNode) { s = string; node = treeNode; }
    }


    /**
     * 辅助栈 速度较慢
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(Integer.valueOf(node.val));
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
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
