package LeetCode.Node链表;
import	java.util.LinkedList;
import	java.util.Stack;
import	java.util.ArrayList;

import java.util.List;
import java.util.Stack;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/22 15:19
 */
public class Node {
    private int value;
    private Node node;
    private Node left;
    private Node right;
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    public String toString() {
        return this.value + " ";
    }
    public void create(int[]datas) {
        List<Node> list = new ArrayList<Node> ();
        for (int i = 0; i < datas.length; i++) {
            Node node = new Node(datas[i]);
            list.add(node);
        }
        for (int i = 0; i < list.size() / 2 - 1; i++) {
            list.get(i).left = list.get(i*2+1);
            list.get(i).right = list.get(i*2+2);
        }
        int index = list.size()/2 - 1;
        list.get(index).setLeft(list.get(index*2+1));
        if (list.size() % 2 == 1) list.get(index).setRight(list.get(index*2+2));
    }
    //递归前序遍历
    private void preTravel(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
        preTravel(node.left);
        preTravel(node.right);
    }
    //递归中序遍历
    private void midTravel(Node node) {
        if (node == null) {
            return;
        }
        preTravel(node.left);
        System.out.println(node.getValue());
        preTravel(node.right);
    }
    //递归后序遍历
    private void postTravel(Node node) {
        if (node == null) {
            return;
        }

        preTravel(node.left);
        preTravel(node.right);
        System.out.println(node.getValue());
    }
    //非递归前序遍历
    public void preOrderTraversal( Node node) {
        Stack<Node> stack = new Stack<Node> ();
        Node p = node;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.println(p.getValue()+" ");
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }
    //非递归中序遍历
    public void midOrderTraversal(Node node) {
        Stack<Node> stack = new Stack<Node>();
        Node p = node;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;

            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.println(p.getValue() + " ");
                p = p.right;
            }
        }
    }
    //非递归后续序遍历
    public void  postOrderTraversal(Node node ) {
       Stack<Node> s = new Stack<>();
       Node cur = node,pre = null;
       while (cur!=null) {
           s.push(node);
           cur = cur.left;
       }
       while (cur != null || !s.isEmpty()) {
           cur = s.pop();
           if (cur.right != null && cur.getRight() != pre) {
               s.push(cur);
               cur = cur.right;
               while (cur != null) {
                   s.push(cur) ;
                   cur = cur.left;
               }
           }else {
               System.out.println(cur.getValue());
               pre = cur;
           }
       }
    }
    public  void bfs(Node node) {
        LinkedList<Node> quene = new LinkedList<> ();
        quene.offer(node);
        while (quene.size()!=0) {
            Node p = quene.pop();
            System.out.println(p.value+ " ");
            if (p.left!=null) quene.offer(p.left);
            if (p.right!=null) quene.offer(p.right);
        }
    }

}
