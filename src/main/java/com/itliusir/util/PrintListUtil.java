package com.itliusir.util;

/**
 * 打印链表
 * @author liugang
 * @date 2019-10-20
 */
public class PrintListUtil {

    public static void printList(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        System.out.print(listNode.val + " ");
        ListNode next = listNode.next;
        while (next != null) {
            System.out.print(next.val + " ");
            next = next.next;
        }
    }
}
