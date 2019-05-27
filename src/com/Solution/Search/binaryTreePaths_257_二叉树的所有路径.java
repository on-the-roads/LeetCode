package com.Solution.Search;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 思路：回溯
 */
public class binaryTreePaths_257_二叉树的所有路径 {
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return list;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dfs_trace(root, sb);
        return list;
    }

    private void dfs_trace(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
            return;
        }
        if (root.left != null) {
            sb.append("->" + root.left.val);
            dfs_trace(root.left, sb);
            int len = String.valueOf(root.left.val).length() + 2;
            sb.delete(sb.length() - len, sb.length());
        }
        if (root.right != null) {
            sb.append("->" + root.right.val);
            dfs_trace(root.right, sb);
            int len = String.valueOf(root.right.val).length() + 2;
            sb.delete(sb.length() - len, sb.length());
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(37);
        root.left = new TreeNode(34);
        root.right = new TreeNode(48);
//        root.left.right = new TreeNode(5);
        List<String> list = new binaryTreePaths_257_二叉树的所有路径().binaryTreePaths(root);
    }
}
