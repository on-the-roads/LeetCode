package com.Solution.LinkedList;

/**
 * 题目：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 要求：请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数
 *
 * 思路：设置两个移动结点odd和even,每次指向下一个结点后将下一个结点赋予当前结点，最后将偶链表和奇链表进行合并。
 */
public class oddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenfirst=head.next;
        while (even!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenfirst;//将偶链表和奇链表进行合并。
        return head;
    }

}
