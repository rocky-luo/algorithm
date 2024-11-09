package com.rocky.algorithm.tree;

public class TreeSearch {

    /**
     * 中序遍历
     */
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.printf(root.value + "");
        inorderTraversal(root.right);

    }

    /**
     * 先序遍历
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf(root.value + "");
        preorderTraversal(root.left);
        preorderTraversal(root.right);

    }
}
