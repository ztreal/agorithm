package algorithm.AddTwoNum;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 * 问题描述
 * 给定两个链表分别代表两个非负整数，链表的每个结点分别存储整数的每位数字，且是逆序存储，即：数字最低位存储在链表表头，数字最高位存储在链表表尾。求解这两个整数的和并以相同的链表形式返回计算的结果。
 * <p>
 * 例如：   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)   输出：7 -> 0 -> 8
 *
 * @author zhangtan
 * @version 1.0
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;

        return calc(l1, l2, carry);
    }

    public static ListNode calc(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                return new ListNode(carry);
            } else {
                return null;
            }
        }

        int sum = 0;
        sum = sum + (l1 != null ? l1.val : 0);
        sum = sum + (l2 != null ? l2.val : 0);
        sum = sum + carry;
        carry = sum / 10;
        sum = sum % 10;
        ListNode newNode = new ListNode(sum);

        newNode.next = calc(l1 != null ? l1.next : l1, l2 != null ? l2.next : l2, carry);

        return newNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1, l2));
        System.out.println(addTwoNumbers2(l1, l2));
    }


    /**
     * 非递归方式实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode dummy = pre;
        int carry = 0;

        while ((l1 != null && l2 != null) || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            int value = sum % 10;
            carry = sum / 10;
            cur.val = value;
            dummy.next = cur;
            dummy = dummy.next;
            l1 = (l1 == null ? l1 : l1.next);
            l2 = (l2 == null ? l2 : l2.next);
        }

        if (l1 == null && l2 != null) {
            dummy.next = l2;
        }

        if (l1 != null && l2 == null) {
            dummy.next = l1;
        }

        return pre.next;
    }
}