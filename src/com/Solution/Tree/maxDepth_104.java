package com.Solution.Tree;

/**
 * 题目：二叉树的最大深度
 * 思路：递归思想
 */
public class maxDepth_104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }

    public static void main(String[] args) {

    }
}
