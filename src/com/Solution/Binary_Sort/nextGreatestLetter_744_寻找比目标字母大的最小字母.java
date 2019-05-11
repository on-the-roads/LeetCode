package com.Solution.Binary_Sort;

/**
 * 题目：给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 思路：该题为二分查找的变种，根据在一个有重复元素的数组中查找key的最左位置的思路模板，
 * 在该题中相当于查找在一个有重复元素的数组中查找target+1的最左位置。
 * 如果最后定位到数组最后一个元素，判断数组最后一个元素是否真的大于target，不大于则返回数组最左边的值。
 */
public class nextGreatestLetter_744_寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters==null||letters.length==0)
            return target;
        int l=0;
        int r=letters.length-1;
        while(l<r)
        {
            int m=l+(r-l)/2;
            if(letters[m]>=(target+1))
                r=m;
            else
                l=m+1;
        }
        if(l==letters.length-1&&letters[letters.length-1]<=target)//判断数组最后一个元素是否真的大于target
            return letters[0];
        return letters[l];
    }

    public static void main(String[] args) {
        char[] ch={'c', 'f', 'j'};
        char ans =new nextGreatestLetter_744_寻找比目标字母大的最小字母().nextGreatestLetter(ch,'a');
        System.out.println(ans);
    }
}
