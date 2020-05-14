package com.rocky.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        addNode(0, result, root);
        return result;

    }

    private void addNode(int level, List<List<Integer>> result, TreeNode node) {
        if (node == null) return;
        List<Integer> thisLevel;
        if (result.size() > level) {
            thisLevel = result.get(level);
        } else {
            thisLevel = new ArrayList<>();
            result.add( thisLevel);
        }
        thisLevel.add(node.val);
        addNode(level+1, result, node.left);
        addNode(level+1, result, node.right);
    }
}
