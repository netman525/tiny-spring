package com.terminus.algorithm.leetcode.binarytree;

import com.terminus.algorithm.leetcode.TreeNode;

import java.util.*;

/**
 * @description:
 *   二叉树的前序、中序、后续遍历
 *
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2020/4/15
 * @since version1.0 Copyright 2020 terminus.io All Rights Reserved.
 */
public class TestBinaryTreeTraversal {

    /**
     * 前序遍历
     */
    private static List<Integer> preOrderTraversal(TreeNode treeNode) {
        //输出
        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        if (Objects.isNull(treeNode)) {
            return output;
        }
        temp.add(treeNode);
        while (!temp.isEmpty()) {
            TreeNode last = temp.pollLast();
            output.add(last.val);
            if (Objects.nonNull(last.right)) {
                temp.add(last.right);
            }
            if (Objects.nonNull(last.left)) {
                temp.add(last.left);
            }
        }
        return output;
    }

    /**
     * 中序遍历方法一、
     * 使用递归。这是经典的方法，直截了当。我们可以定义一个辅助函数来实现递归。
     *
     * @param treeNode
     * @return
     */
    private static List<Integer> inOrderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(treeNode, result);
        return result;

    }

    private static void inOrderHelper(TreeNode root, List<Integer> result) {
        if (Objects.nonNull(root)) {
            if (Objects.nonNull(root.left)) {
                inOrderHelper(root.left, result);
            }
            result.add(root.val);
            if (Objects.nonNull(root.right)) {
                inOrderHelper(root.right, result);
            }
        }
    }


    /**
     * 基于栈的遍历
     *
     * @param root
     * @return
     */
    private static List<Integer> inOrderTraversalMethodTwo(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (Objects.nonNull(curr) || !stack.isEmpty()) {
            while (Objects.nonNull(curr)) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;

    }


    /**
     * 后续遍历
     *
     * @param root
     * @return
     */
    private static List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (Objects.isNull(root)) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            output.addFirst(treeNode.val);
            if (Objects.nonNull(treeNode.left)) {
                stack.add(treeNode.left);
            }
            if (Objects.nonNull(treeNode.right)) {
                stack.add(treeNode.right);
            }
        }
        return output;
    }


    /**
     * 3
     * / \
     * 9  20
     * / \
     * 15  7
     * /
     * 6
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
        System.out.println("<=========前序遍历=========>");
        System.out.println(preOrderTraversal(head));
        System.out.println("<=========中序遍历=========>");
        System.out.println(inOrderTraversal(head));
        System.out.println(inOrderTraversalMethodTwo(head));
        System.out.println("<=========后序遍历=========>");
        System.out.println(postOrderTraversal(head));
    }
}
