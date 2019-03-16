package com.Solution.LinkedList;

/**
 * 题目:求两个链表相交的第一个结点，要求时间复杂度为O(n),空间复杂度为O(1)。若无相交结点则返回null。
 * 思路：假设链表A和链表B的公共部分长度为c,A和B私有部分的长度分别为a和b，则a+c+b=b+c+a.
 *      这个表达式的意思是A和B同时从他们的头结点开始向后访问，
 *      当A访问到链表末尾时开始从B头结点访问；同样，当B访问到链表末尾时开始从A头结点访问。
 *      最终，他们会在第一个相交结点相遇。若AB没有相交结点，那么他们会最终同时指向null.
 *
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        while(A!=B)
        {
            A=(A==null)?headB:A.next;
            B=(B==null)?headA:B.next;
        }
        return  A;
    }

    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(3);
        ListNode B=new ListNode(4);
        B.next=new ListNode(3);
        ListNode ans=new IntersectionOfTwoLinkedList().getIntersectionNode(A,B);
    }
}
