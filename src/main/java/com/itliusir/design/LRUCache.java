package com.itliusir.design;

import java.util.*;

/**
 * problem.146
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author liugang
 * @since 2019/9/10
 */
public class LRUCache {

    private Map<Integer,Integer> map = new LinkedHashMap<>();

    private LinkedList<Integer> list = new LinkedList<>();

    private int capacity;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public LRUCache(int size) {
        map = new LinkedHashMap<>(size);
        capacity = size;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(Integer.valueOf(key));
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() >= capacity) {
            Integer first = list.removeFirst();
            map.remove(first);
            map.put(key, value);
        } else if (map.containsKey(key)) {
            map.put(key, value);
            list.remove(Integer.valueOf(key));
        } else {
            map.put(key, value);
        }
        list.addLast(key);
    }
}
