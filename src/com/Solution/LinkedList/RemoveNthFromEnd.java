package com.Solution.LinkedList;

/**
 * 题目：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 要求：尝试使用一趟扫描实现
 * 思路：使用两个指针对链表进行扫描，node2与node1之间间隔n个结点。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode node1 = head;
        int i = 1;
        for (i = 1; i <= n && node1 != null; i++) {
            node1 = node1.next;
        }
        if (i <= n)
            return head;
        if (i == n + 1 && node1 == null)
            return head.next;
        ListNode node2 = head;
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next=node2.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode ans=new RemoveNthFromEnd().removeNthFromEnd(head,3);
    }
}
