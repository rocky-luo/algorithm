package com.rocky.algorithm.linkedlist;

import java.util.Stack;

public class StackReverseLinkedList implements ReverseLinkedList{
    @Override
    public LinkedListNode reverse(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        Stack<LinkedListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        LinkedListNode newHead = stack.pop();
        LinkedListNode tail = newHead;
        while (!stack.isEmpty()) {
            LinkedListNode pop = stack.pop();
            tail.next = pop;
            tail = pop;
        }
        tail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Checker.check(new StackReverseLinkedList());
    }
}
