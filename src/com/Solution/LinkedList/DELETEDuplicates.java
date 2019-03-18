package com.Solution.LinkedList;

/**
 *题目：从有序链表中删除重复结点
 * 思路：递归思路
 */
public class DELETEDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        while (head.next != null && head.val == head.next.val)
            head = head.next;
        head.next = deleteDuplicates(head.next);
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next = new ListNode(3);
        ListNode ans = new DELETEDuplicates().deleteDuplicates(root);
    }
}
