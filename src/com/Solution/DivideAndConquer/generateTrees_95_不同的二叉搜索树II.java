package com.Solution.DivideAndConquer;

import com.Solution.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 思路：分治思想
 */
public class generateTrees_95_不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0)
            return new ArrayList<>();
        List<TreeNode> ans=generate(1,n);
        return  ans;
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list=new ArrayList<>();
        if(start>end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> left=generate(start,i-1);
            List<TreeNode> right=generate(i+1,end);
            for(TreeNode l:left)
                for(TreeNode r:right)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    list.add(root);
                }
        }
        return list;
    }


    public static void main(String[] args) {
        List<TreeNode> ans=new generateTrees_95_不同的二叉搜索树II().generateTrees(3);
    }
}
