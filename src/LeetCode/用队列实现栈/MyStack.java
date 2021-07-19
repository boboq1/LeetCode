package LeetCode.用队列实现栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: hechenbo
 * @Description: 用队列实现栈
 * @DateTime: 2021/7/19 15:25
 **/
public class MyStack {
    private Deque<Integer> deque;
    /** Initialize your data structure here. */
    public MyStack() {
        deque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.pollFirst();
    }

    /** Get the top element. */
    public int top() {
        return deque.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
