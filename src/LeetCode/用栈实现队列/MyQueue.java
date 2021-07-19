package LeetCode.用栈实现队列;

import java.util.Stack;

/**
 * @Author: hechenbo
 * @Description: 用栈实现队列
 * @DateTime: 2021/7/19 14:51
 **/
public class MyQueue {

   private Stack<Integer> pushStack;
   private Stack<Integer> popStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (popStack.isEmpty())
        pushStack.push(x);
        else {
            int n = popStack.size();
            for (int i = 0; i < n; i++) {
                pushStack.push(popStack.pop());
            }
            pushStack.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (pushStack.isEmpty() && !popStack.isEmpty())return popStack.pop();
        if (!pushStack.isEmpty()) {
            popStack.clear();
            int n = pushStack.size();
            for (int i = 0; i < n; i++) {
                popStack.add(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!pushStack.isEmpty()) {
            popStack.clear();
            int n = pushStack.size();
            for (int i = 0; i < n; i++) {
                popStack.add(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (pushStack.isEmpty() && popStack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
