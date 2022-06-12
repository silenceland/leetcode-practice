package com.silenceland.leetcode.designpattern;

/**
 * @author silenceland
 * @description ListNode
 * @date 2022/2/11
 */
public class ListNode {

    int num;
    ListNode next;

    public ListNode(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
