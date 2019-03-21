package com.Solution.LinkedList;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 要求：如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 思路
 * 思路1：将两个链表的数提取出来进行相加，再将他们的和构造成结果链表。
 * 思路2：利用堆栈，将两个链表的数从末节点开始依次相加
 */
public class ADDTwoNumbers {
//    /**
//     * 思路1
//     * @param l1
//     * @param l2
//     * @return
//     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int sum1=0;
//        int sum2=0;
//        if(l1.val==0&&l2.val==0)
//            return new ListNode(0);
//        ListNode node1=l1;
//        ListNode node2=l2;
//        while(node1!=null)
//        {
//                sum1=sum1*10+node1.val;
//                node1=node1.next;
//        }
//        while (node2!=null)
//        {
//            sum2=sum2*10+node2.val;
//            node2=node2.next;
//        }
//        int sum=sum1+sum2;
//        ListNode ans=construc(sum);
//        return ans;
//    }
//
//    /**
//     * 递归思想：从末尾结点向头结点一步步构造链表
//     * @param val
//     * @return
//     */
//    private ListNode construc(int val) {
//       if(val==0)
//           return null;
//       int yu=val%10;
//       int shang=val/10;
//       if(shang==0)
//           return new ListNode(yu);
//       ListNode node=construc(shang);
//       ListNode node2=new ListNode(yu);
//       ListNode temp=node;
//       while (temp.next!=null)
//           temp=temp.next;
//       temp.next=node2;
//       return node;
//    }

    /**
     * 思路2
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack();
        Stack<Integer> stack2=new Stack();
        while (l1!=null) {
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null)
        {
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;//进位标志
        ListNode head=null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0)
        {
            int x=stack1.isEmpty()?0:stack1.pop();
            int y=stack2.isEmpty()?0:stack2.pop();
            int sum=x+y+carry;
            ListNode node=new ListNode(sum%10);
            carry=sum/10;
            node.next=head;
            head=node;
        }
        return  head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode ans = new ADDTwoNumbers().addTwoNumbers(node1, node2);
    }
}
