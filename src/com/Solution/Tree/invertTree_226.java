package com.Solution.Tree;

/**
 * 题目：翻转一颗二叉树
 * 思路：对每一个结点，将左右子树进行交换。（递归思想）
 */
public class invertTree_226 {
    //方法1
//    public TreeNode invertTree(TreeNode root) {
//        swap(root);
//        return root;
//    }
//
//    private void swap(TreeNode root) {
//        if(root==null)
//            return;
//        TreeNode temp=null;
//        temp=root.left;
//        root.left=root.right;
//        root.right=temp;
//        swap(root.left);
//        swap(root.right);
//    }

    //方法2：将方法1的两个子方法进行整合
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        /*
            下面三行代码的作用是交换root的左右子树并返回root
         */
        TreeNode left=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(left);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        TreeNode ans = new invertTree_226().invertTree(root);
    }
}
