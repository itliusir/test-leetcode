package com.itliusir.design;

/**
 * generate a hashSet
 *
 * @author liugang
 * @since 2020/1/17
 */
public class MyHashSet {

    final ListNode[] table = new ListNode[10000];

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(7);
        set.add(6);
        System.out.println(set.contains(5));
        System.out.println(set.contains(7));
        System.out.println(set.contains(6));
    }


    public void add(int key) {
        int idx = idx(key);
        if (table[idx] == null) {
            table[idx] = new ListNode(-1);
        }
        ListNode prev = find(table[idx], key);
        if (prev.next == null) {
            prev.next = new ListNode(key);
        } else {
            prev.next.value = key;
        }
    }

    public void remove(int key) {
        int idx = idx(key);
        if (table[idx] == null) {
            return;
        }
        ListNode prev = find(table[idx], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }

    public boolean contains(int key) {
        int idx = idx(key);
        if (table[idx] == null) {
            return false;
        }
        ListNode prev = find(table[idx], key);
        if (prev.next == null) {
            return false;
        } else {
            return true;
        }
    }

    int idx(int key) {
        return Integer.hashCode(key) % table.length;
    }

    ListNode find(ListNode node, int key) {
        ListNode curr = node, prev = null;
        while (curr != null && curr.value != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }


    class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
