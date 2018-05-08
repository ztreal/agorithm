package algorithm.ConvertSortedListToBinarySearchTree;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 * 2、4、6、8、10、12、14
 *
 * @author zhangtan
 * @version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        TreeNode treeNode = solution.sortedListToBST(listNode);
        System.out.println(treeNode);
    }

    private TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return constructBST(head, null);
    }

    private TreeNode constructBST(ListNode head, ListNode tail) {
        TreeNode node = null;
        if (head != tail) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            node = new TreeNode(slow.val);
            node.left = constructBST(head, slow);
            node.right = constructBST(slow.next, tail);
        }
        return node;

    }
}
