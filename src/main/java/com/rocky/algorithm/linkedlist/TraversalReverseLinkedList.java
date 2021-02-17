package com.rocky.algorithm.linkedlist;

/**
 * 遍历
 */
public class TraversalReverseLinkedList implements ReverseLinkedList{

    @Override
    public LinkedListNode reverse(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        LinkedListNode current = head;
        LinkedListNode pre = null;
        LinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        // 最后current指向了null，pre指向了新的head
        return pre;
    }

    public static void main(String[] args) {
        Checker.check(new TraversalReverseLinkedList());
    }
}
