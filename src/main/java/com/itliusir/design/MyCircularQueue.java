package com.itliusir.design;

/**
 * TODO
 *
 * @author liugang
 * @since 2020/1/17
 */
public class MyCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }

    final int[] table;
    int front, rear = -1, len = 0;

    public MyCircularQueue(int k) {
        table = new int[k];
    }

    /**
     * 插入元素
     */
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % table.length;
            table[rear] = value;
            len++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除元素
     */
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % table.length;
            len--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取队首元素
     */
    public int Front() {
        return isEmpty() ? -1 : table[front];
    }

    /**
     * 获取队尾元素
     */
    public int Rear() {
        return isEmpty() ? -1 : table[rear];
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return len == 0;
    }

    /**
     * 是否已满
     */
    public boolean isFull() {
        return len == table.length;
    }
}
