package algorithm.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 * binary tree inorder traversal 中序遍历:左根右  前序：根左右   后续：左右根
 * given binary tree[1,nul,2,3] return [1,3,2]
 *
 * @author zhangtan
 * @version 1.0
 */
public class Solution {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while ((root != null) || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
                continue;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode.right = treeNode2;
        treeNode.left = treeNode4;
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        treeNode2.left = treeNode3;
        System.out.println(inorderTraversal(treeNode));
    }
}
