package com.terminus.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @description:
 * @date Create on 2020/4/15
 * @since version1.0 Copyright 2020 terminus.io All Rights Reserved.
 */
public class TestBalanceTree {

    /**
     * 将二叉树按数据格式打印
     *
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }


    /**
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getTreeHeight(root) >= 0 ? true : false;
    }

    /**
     *
     * @param treeNode
     * @return
     */
    private static int getTreeHeight(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        }
        int leftDepth = getTreeHeight(treeNode.left);
        System.out.println("root=" + treeNode.val + ",leftDepth=" + leftDepth);
        int rightDepth = getTreeHeight(treeNode.right);
        System.out.println("root=" + treeNode.val + ",rightDepth=" + rightDepth);
        if (leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * <p>
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node2_1 = new TreeNode(15);
        TreeNode node2_2 = new TreeNode(7);
        TreeNode node2_1_1 = new TreeNode(6);
        head.left = node1;
        head.right = node2;
        node2.left = node2_1;
        node2.right = node2_2;
        node2_1.left = node2_1_1;
        //System.out.println(isBalanced(head));

        System.out.println(preOrderTraversal(head));

        TreeNode head22 = new TreeNode(1);
        TreeNode node22_1 = new TreeNode(2);
        TreeNode node22_2 = new TreeNode(2);
        TreeNode node22_1_1 = new TreeNode(3);
        TreeNode node22_1_2 = new TreeNode(3);
        TreeNode node22_1_1_1 = new TreeNode(4);
        TreeNode node22_1_1_2 = new TreeNode(4);
        head22.left = node22_1;
        head22.right = node22_2;
        node22_1.left = node22_1_1;
        node22_1.right = node22_1_2;
        node22_1_1.left = node22_1_1_1;
        node22_1_1.right = node22_1_1_2;
        //System.out.println(isBalanced(head22));
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
