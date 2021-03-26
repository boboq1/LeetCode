package LeetCode.栈.最小栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: hcb
 * @Date: 2021/2/25 17:28
 * @Version 1.0
 */
public class MinStack {
    /** initialize your data structure here. */
    /*private List<Integer> data;
    public MinStack() {
        data = new LinkedList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.remove(data.size() - 1);
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.get(data.size() - 1);
        }
        return -1;
    }

    public int getMin() {
        if (data.size() == 0) return -1;
        int min = Integer.MAX_VALUE;
        for (Integer datum : data) {
            min = Math.min(datum,min);
        }
        return min;
    }*/
    /** initialize your data structure here. */
    /*private Node node;
    public MinStack() {
    }

    public void push(int x) {
        if (node == null) {
            node = new Node(x,x);
        } else {
            Node next = new Node(x, Math.min(x,node.min));
            next.prev = node;
            node = next;
        }
    }

    public void pop() {
        node = node.prev;
    }

    public int top() {
        return node == null ? -1 : node.val;
    }

    public int getMin() {
        return node != null ?node.min : -1;
    }
    class Node{
        public int val;
        public Node prev;
        public int min;
        public Node(){}
        public Node(int val,int min){
            this.val = val;
            this.min = min;
        }
    }*/
    private Stack<int[]> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x,x});
        } else {
            stack.push(new int[]{x,Math.min(x,stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
