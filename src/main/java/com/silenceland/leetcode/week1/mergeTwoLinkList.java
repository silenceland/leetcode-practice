package com.silenceland.leetcode.week1;

/**
 * 两个有序单链表l1、l2，合并为一个有序单链表
 */
public class mergeTwoLinkList {

    public static void main(String[] args) {
        // test
    }

    public static ListNode method(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while (l1 != null & l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                prev.setVal(l1.getVal());
                l1 = l1.getNext();
            } else {
                prev.setVal(l2.getVal());
                l2 = l2.getNext();
            }

            prev = prev.getNext();
        }

        if (l1 == null) {
            prev.setNext(l2);
        } else {
            prev.setNext(l1);
        }

        return head.getNext();
    }
}
