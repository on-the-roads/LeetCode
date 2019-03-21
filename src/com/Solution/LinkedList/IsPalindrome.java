package com.Solution.LinkedList;

/**
 * 题目：请判断一个链表是否为回文链表。
 * 要求：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 思路：将链表平均分成两半，翻转其中一半，依次比较结点元素是否相等
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)//链表共有偶数个结点
            slow = slow.next;
        cut(head, slow);
        slow = reverse(slow);
        return IsEqual(head, slow);
    }

    private ListNode reverse(ListNode node) {
        ListNode vihead = null;
        while (node != null) {
            ListNode nextnode = node.next;
            node.next = vihead;
            vihead = node;
            node = nextnode;
        }
        return vihead;
    }

    /**
     * 判断两个链表是否相等
     * @param head
     * @param slow
     * @return
     */
    private boolean IsEqual(ListNode head, ListNode slow) {
        while (head != null && slow != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }


    /**
     * 将链表平均分成两份，分别以head和slow作为头结点
     *
     * @param head
     * @param slow
     */
    private void cut(ListNode head, ListNode slow) {
        while (head.next != slow)
            head = head.next;
        head.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        boolean ans = new IsPalindrome().isPalindrome(head);
    }
}
