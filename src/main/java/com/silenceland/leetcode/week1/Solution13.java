package com.silenceland.leetcode.week1;

/**
 * 单链表翻转
 */
public class Solution13 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        l1.setNext(l2);
        l2.setNext(l3);

        method(l1);
    }

    private static ListNode method(ListNode head) {
        ListNode before = new ListNode(-1);
        ListNode current = head;

        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(before);
            before = current;
            current = next;
        }

        return before;
    }
}
