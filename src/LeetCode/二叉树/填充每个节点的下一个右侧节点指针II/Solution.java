package LeetCode.二叉树.填充每个节点的下一个右侧节点指针II;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hcb
 * @Date: 2021/2/14 15:20
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
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i < size - 1) {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }*/
    Node last = null;
    Node nextStart = null;
    public Node connect(Node root) {
        if (root == null) return root;
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node node = start;node != null;node = node.next) {
                if (node.left != null) {
                    hanlder(node.left);
                }
                if (node.right != null) {
                    hanlder(node.right);
                }
            }
            start = nextStart;
        }
        return root;
    }
    public void hanlder(Node node) {
        if (last != null) {
            last.next = node;
        }
        if (nextStart == null) {
            nextStart = node;
        }
        last = node;
    }
}
