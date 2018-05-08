package com.zt.leetcode.ConvertSortedListToBinarySearchTree;

import com.google.common.base.MoreObjects;

/**
 *  .
 *
 * @author zhangtan
 * @version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("val", val)
                .add("left", left)
                .add("right", right)
                .toString();
    }
}
