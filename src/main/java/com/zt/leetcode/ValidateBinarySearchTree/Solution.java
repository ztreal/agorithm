package com.zt.leetcode.ValidateBinarySearchTree;

/**
 * 判断一个二叉树是否为二分查找树。
 * <p>
 * 何为二分查找树？1) 左子树的值都比根节点小；2) 右子树的值都比根节点大；3) 左右子树也必须满足上面两个条件。
 * <p>
 * 需要注意的是，左子树的所有节点都要比根节点小，而非只是其左孩子比其小，右子树同样。这是很容易出错的一点是，很多人往往只考虑了每个根节点比其左孩子大比其右孩子小。如下面非二分查找树，如果只比较节点和其左右孩子的关系大小，它是满足的。
 *
 * @author zhangtan
 * @version 1.0
 */
public class Solution {
    // Keep the previous value in inorder traversal.
    private long preVal = (long) Integer.MIN_VALUE - 1;

    public boolean isValiBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isValiBST(root.left)) {
            return false;
        }

        if (!(preVal < root.val)) {
            return false;
        }

        preVal = root.val;
        return isValiBST(root.right);

    }
}
