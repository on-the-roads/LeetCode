package com.Solution.Tree;


/**
 * 题目：给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 思路：当根节点存在时，直径长度为：（左树高度-1）+（右树高度-1）
 */
public class diameterOfBinaryTree_543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        ans = left + right - 2;//直径长度为：（左树高度-1）+（右树高度-1）
        return left > right ? (left + 1) : (right + 1);
    }
}
