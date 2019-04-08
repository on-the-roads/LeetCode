package com.Solution.TRACE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：输入一个数组arr,输出数组中和为给定值的所有子序列
 * 思路：递归思路，遍历数组，对每个元素有两种选择，添加或者不添加。
 */
public class KugouProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String s = sc.nextLine();
        int target = sc.nextInt();
        String[] ss = s.split(",");
        int[] arr = new int[ss.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        Arrays.sort(arr);
        boolean[] flags = new boolean[arr.length];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        find(arr, 0, 0, target, flags, lists);
        if (lists.size() != 0) {
            for (ArrayList<Integer> li : lists) {
                for (int i : li)
                    System.out.print(i + " ");
                System.out.println();
            }
        }
    }

    private static void find(int[] arr, int index, int sum, int target, boolean[] flags, ArrayList<ArrayList<Integer>> lists) {

        if (sum == target) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < flags.length; i++) {
                if (flags[i])
                    list.add(arr[i]);
            }
            lists.add(list);
            return;
        }

        if (index >= arr.length || sum > target)
            return;

        //添加该元素
        flags[index] = true;
        sum += arr[index];
        find(arr, index + 1, sum, target, flags, lists);
        //不添加该元素
        flags[index] = false;
        sum -= arr[index];
        find(arr, index + 1, sum, target, flags, lists);
    }
}
