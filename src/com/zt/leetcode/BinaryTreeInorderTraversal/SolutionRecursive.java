package algorithm.BinaryTreeInorderTraversal;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 * 左根右
 *
 * @author zhangtan
 * @version 1.0
 */
public class SolutionRecursive {


    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left);
            System.out.println(node.val);
            inOrderTraversal(node.right);
        }
    }
}
