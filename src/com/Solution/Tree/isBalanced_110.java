package com.Solution.Tree;

/**
 * 题目：判断是否为平衡二叉树，即任意结点的左右子树高度差值小于等于1
 */
public class isBalanced_110 {
    public boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        getNum(root);
        return ans;
    }

    private int getNum(TreeNode node) {
        if (node == null)
            return 0;
        int left = getNum(node.left);
        int right = getNum(node.right);
        if (Math.abs(left - right) > 1)
            ans = false;
        return Math.max(left, right) + 1;
    }

}
