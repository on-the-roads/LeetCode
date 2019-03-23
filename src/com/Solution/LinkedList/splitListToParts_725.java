package com.Solution.LinkedList;

/**
 * 题目：把链表分隔成 k 部分，每部分的长度都应该尽可能相同，排在前面的长度应该大于等于后面的。
 * 思路： 先计算出链表的结点个数N，设置两个变量size和mod，size=N/k,mod=N%k,则前mod个链表段中结点的个数都为size+1,后面链表段的结点个数为size。
 */
public class splitListToParts_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; i++) {
            ans[i] = cur;
            int curSize = size + (mod--) > 0 ? 1 : 0;
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur==null?null:cur.next;
            if (cur!= null)
                cur.next = null;
            cur = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode[] ans = new splitListToParts_725().splitListToParts(head, 4);
    }
}
