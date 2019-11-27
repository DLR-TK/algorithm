package com.tk.algorithm.postorder_traversal145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("all")
public class Solution {


    /**
     * 模拟命令栈 思路最清晰 速度最慢
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

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

                stack.push(new Command("print", command.node));
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return res;
    }

    public class Command {
        String s;
        TreeNode node;
        Command(String string, TreeNode treeNode) { s = string; node = treeNode; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
