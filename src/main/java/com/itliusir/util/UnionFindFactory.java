package com.itliusir.util;

/**
 * 并查集模板类
 * @author liugang
 * @date 2019-11-24
 */
public class UnionFindFactory {
    private int count = 0;
    private int[] parent;

    public UnionFindFactory(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count --;
    }

    public int getCount() {
        return count;
    }
}
