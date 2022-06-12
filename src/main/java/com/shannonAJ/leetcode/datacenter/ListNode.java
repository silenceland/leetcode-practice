package com.shannonAJ.leetcode.datacenter;

public class ListNode {
    private int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}
