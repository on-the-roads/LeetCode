package com.Solution.Top100;

import com.Solution.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists_23_合并K个排序链表 {

    /**
     * 思路1 ：使用堆排序，每次从k个链表的头结点中选取值最小的结点构建链表
     * 时间复杂度O(Nlogk)，N为链表总元素个数
     * 空间复杂度O(k)
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode vhead = new ListNode(-1);
        ListNode node = vhead;
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> dui = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null)
                dui.offer(head);
        }

        while (dui.size() != 0) {
            ListNode temp = dui.poll();
            node.next = temp;
            if (temp.next != null) {
                temp = temp.next;
                dui.offer(temp);
            }
            node = node.next;
        }
        return vhead.next;
    }


    /**
     * 思路2：归并，分治思想
     * 时间复杂度O(Nlogk)
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        return mergeSort(lists,0,lists.length-1);
    }


    private ListNode mergeSort(ListNode[] lists,int l, int r){
        if(l==r)
            return lists[l];
        if(l<r){
            int mid=l+(r-l)/2;
            ListNode l1=mergeSort(lists,l,mid);
            ListNode l2=mergeSort(lists,mid+1,r);
            return mergeTwoLists(l1,l2);
        }
        return null;
    }


    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
