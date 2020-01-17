package com.itliusir.design;

class MyCircularDeque {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());
    }

    final int[] queue;
    int front, rear;
    int capacity;
    int count;

    public MyCircularDeque(int k) {
        queue = new int[k];
        capacity = k;
        front = 0;rear = 0;
        count = 0;
    }

    /**
     * 将一个元素添加到双端队列头部
     * */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        queue[front] = value;
        front = (front - 1 + capacity) % capacity;
        count++;
        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部
     * */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        count++;
        return true;
    }

    /**
     * 从双端队列头部删除一个元素
     * */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front+1) % capacity;
        count--;
        return true;
    }

    /**
     * 从双端队列尾部删除一个元素
     * */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        count--;
        return true;
    }

    /**
     * 从双端队列头部获得一个元素
     * */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(front + 1) % capacity];
    }

    /**
     * 获得双端队列的最后一个元素
     * */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    /**
     * 将一个元素添加到双端队列头部
     * */
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}