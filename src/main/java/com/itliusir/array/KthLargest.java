package com.itliusir.array;

import java.util.PriorityQueue;

public class KthLargest {

    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 3, 2, 1};
        KthLargest kthLargest = new KthLargest(7, a);
        int result = kthLargest.add(7);
        System.out.println(result);
    }
}