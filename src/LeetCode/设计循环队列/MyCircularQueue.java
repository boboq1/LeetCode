package LeetCode.设计循环队列;

import Java.队列_实现.MyQueue;

/**
 * @Author: hcb
 * @Date: 2021/2/7 20:00
 * @Version 1.0
 */
class MyCircularQueue {
    //数组
    /*private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (this.count == this.capacity) return false;
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count ++;
        return true;
    }

    public boolean deQueue() {
        if (this.count == 0) return false;
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count --;
        return true;
    }

    public int Front() {
        if (count == 0) return -1;
        return this.queue[this.headIndex];
    }

    public int Rear() {
        if (count == 0) return -1;
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (this.capacity == this.count);
    }*/
    //单链表
    private Node head, tail;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (this.count == this.capacity) return false;
        Node newNode = new Node(value);
        if (count == 0) {
            this.head = this.tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        this.count ++;
        return true;
    }

    public boolean deQueue() {
        if (this.count == 0) return false;
        this.head = this.head.nextNode;
        this.count -- ;
        return true;
    }

    public int Front() {
        if (this.count == 0) {
            return -1;
        }else {
            return this.head.value;
        }
    }

    public int Rear() {
        if (this.count == 0) return -1;
        return this.tail.value;
    }

    public boolean isEmpty() {
        return (this.count == 0);
    }

    public boolean isFull() {
        return (this.count == this.capacity);
    }
}

class Node {
    public int value;
    public Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }
}
