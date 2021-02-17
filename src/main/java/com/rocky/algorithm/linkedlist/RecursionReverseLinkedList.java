package com.rocky.algorithm.linkedlist;

public class RecursionReverseLinkedList implements ReverseLinkedList{
    @Override
    public LinkedListNode reverse(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Checker.check(new RecursionReverseLinkedList());
    }
}
