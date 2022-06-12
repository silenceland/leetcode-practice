package com.shannonAJ.leetcode.datacenter;

import java.util.List;

/**
 * 2.两数之和
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 */
public class twoNumSum {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode()
//        ListNode res = addTwoNumbers()
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. 先初始化一个prev节点
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        int carry = 0;
        int sum = 0;

        while (l1 != null && l2 != null) {
            int x = l1.getVal();
            int y = l2.getVal();

            sum = x + y + carry;
            carry = (x + y) / 10;

            current.next = new ListNode(sum);
            current = current.next;

            if (l1.next != null) {
                l1 = l1.next;
            }

            if (l2.next != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            pre.next = new ListNode(carry);
        }

        return pre.next;
    }
}
