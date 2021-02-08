package Java.队列_实现;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/2/7 17:59
 * @Version 1.0
 */
public class MyQueue {
    private List<Integer> data;
    private int p_start;

    public MyQueue() {
        data = new ArrayList<>();
        p_start = 0;
    }

    public boolean enQueue(int element) {
        data.add(element);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        p_start++;
        return true;
    }

    public int front() {
        return data.get(p_start);

    }

    private boolean isEmpty() {
        return p_start >= data.size();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(7);
        System.out.println(myQueue.deQueue());

        System.out.println(myQueue.front());
    }
}
