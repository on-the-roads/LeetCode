package com.Solution.LinkedList;

/**
 * 题目:实现单链表的反转过程，要求用递归或者迭代方法
 */
public class ReverseLinkedList206 {
    /**
     * 递归思想
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        if(head==null||head.next==null)
//            return head;
//        ListNode next=head.next;
//        ListNode pHead=reverseList(next);
//        next.next=head;
//        head.next=null;
//        return pHead;
//    }

    /**
     * 在原来的头结点前面再加上一个虚拟头结点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode viHead=new ListNode(-1);
        viHead.next=head;
        ListNode New=viHead.next;
        ListNode Old=New.next;
        ListNode Temp=Old.next;
        while (Old!=null){
            Temp=Old.next;
            Old.next=New;
            New=Old;
            Old=Temp;
        }
        viHead.next.next=Old;
        return New;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode ans=new ReverseLinkedList206().reverseList(head);
    }
}
