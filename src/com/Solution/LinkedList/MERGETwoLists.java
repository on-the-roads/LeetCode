package com.Solution.LinkedList;

/**
 * 题目：合并两个有序的链表
 * 归并思想
 */
public class MERGETwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode ans;
        if (l1.val <= l2.val){
             ans=l1;
            ans.next=mergeTwoLists(l1.next,l2);
        }
        else
        {
             ans=l2;
            ans.next=mergeTwoLists(l1,l2.next);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode ans = new MERGETwoLists().mergeTwoLists(node1, node2);
    }
}
