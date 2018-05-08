package algorithm.AddTwoNum;

import com.google.common.base.MoreObjects;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 *
 * @author zhangtan
 * @version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("val", val)
                .add("next", next)
                .toString();
    }
}
