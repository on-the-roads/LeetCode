package com.Solution.TRACE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：输入一个数组arr,将这个数组拆分为两个子数组arr1和arr2,两个子数组的和相等，输出两个数组以及子数组的和，若没有，则返回-1
 * 思路：递归思路，遍历数组，对每个元素有两种选择，添加或者不添加。
 */
public class KugouProblem {
    private static int  flag=0;//判断是否已找到满足要求的标志位
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String s = sc.nextLine();
        String[] ss = s.split(",");
        int[] arr = new int[ss.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        Arrays.sort(arr);
        int Sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Sum += arr[i];
        }
        if (Sum % 2 == 1) {//输入数组和为奇数，不满足条件
            System.out.println("-1");
            return;
        }
        boolean[] flags = new boolean[arr.length];
        int target = Sum / 2;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        find(arr, 0, 0, target, flags, list1, list2);
        for (int i : list1)
            System.out.print(i + " ");
        System.out.println();
        for (int i : list2)
            System.out.print(i + " ");
        System.out.println();
        System.out.println(target);
    }

    private static void find(int[] arr, int index, int sum, int target, boolean[] flags, ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (index >= arr.length || sum > target||flag==1)
            return;
        if (sum == target) {
            flag=1;
            for (int i = 0; i < flags.length; i++) {
                if (flags[i])
                    list1.add(arr[i]);
                else
                    list2.add(arr[i]);
            }
            return;
        }
        //添加该元素
        flags[index] = true;
        sum += arr[index];
        find(arr, index + 1, sum, target, flags, list1, list2);
        //不添加该元素
        flags[index] = false;
        sum -= arr[index];
        find(arr, index + 1, sum, target, flags, list1, list2);
    }
}
