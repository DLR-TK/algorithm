package com.tk.algorithm.path_sum_iii437;

public class Solution {

    /**
     * 在以root为根节点的二叉树中，寻找和为sum的路径，返回路径个数
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {

        if (root == null)
            return 0;

        int res = findPath(root, sum);

        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;

    }

    /**
     * 在以node为根节点的二叉树中，寻找包含node的路径，和为num，返回路径个数
     * @param node
     * @param num
     * @return
     */

    private int findPath(TreeNode node, int num) {

        if (node == null)
            return 0;

        int res = 0;
        if (node.val == num)
            res += 1;

        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
