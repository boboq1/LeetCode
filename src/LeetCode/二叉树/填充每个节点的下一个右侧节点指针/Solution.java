package LeetCode.二叉树.填充每个节点的下一个右侧节点指针;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hcb
 * @Date: 2021/2/14 14:05
 * @Version 1.0
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    /*public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == size - 1) node.next = null;
                else {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }*/
    public Node connect(Node root) {
         Node leftNode = root;
        while (leftNode.left != null) {
            Node head = leftNode;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) head.right.next = head.next.left;
                head = head.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }
}