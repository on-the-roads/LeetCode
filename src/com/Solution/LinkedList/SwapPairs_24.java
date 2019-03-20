package com.Solution.LinkedList;

/**
 * 题目：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 思路：
 * 1：递归思想
 * 2：非递归方法，设置pre,new，old，temp指针
 */
public class SwapPairs_24 {
    /**
     * 1：递归思想
     *
     * @param head
     * @return
     */
//    public ListNode swapPairs(ListNode head) {
//        if(head==null||head.next==null)
//            return  head;
//        ListNode temp=head.next;
//        head.next=temp.next;
//        temp.next=head;
//        head.next=swapPairs(head.next);
//        return temp;
//    }

    /**
     * 非递归方法，设置pre,new，old，temp指针
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode node=pre;

        while (node.next!=null&&node.next.next!=null)
        {
            ListNode New=node.next;
            ListNode old=New.next;
            ListNode temp=old.next;
            //指针翻转过程
            old.next=New;
            New.next=temp;
            node.next=old;
            //node后移，准备下一次循环
            node=New;
        }
        return pre.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode ans = new SwapPairs_24().swapPairs(head);
    }
}
