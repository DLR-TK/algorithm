package com.tk.algorithm.all_possible_full_binary_trees_894;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {

        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        } else if (N % 2 == 1) {
            for (int i = 0; i < N; i++) {
                int j = N - 1 - i;
                for (TreeNode leftNode : allPossibleFBT(i)) {
                    for (TreeNode rightNode : allPossibleFBT(j)) {
                        TreeNode node = new TreeNode(0);
                        node.left = leftNode;
                        node.right = rightNode;
                        res.add(node);
                    }
                }
            }
        }
        cache.put(N, res);

        return cache.get(N);
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
