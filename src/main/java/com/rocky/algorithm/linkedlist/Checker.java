package com.rocky.algorithm.linkedlist;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class Checker {
    public static void check(ReverseLinkedList reverseLinkedList) {
        Assert.assertEquals(linkedListToString(reverseLinkedList.reverse(buildLinkedListByString("a"))), "a");

        Assert.assertEquals(linkedListToString(reverseLinkedList.reverse(buildLinkedListByString("a,b"))), "b,a");

        Assert.assertEquals(linkedListToString(reverseLinkedList.reverse(buildLinkedListByString("a,b,c,d,e"))), "e,d,c,b,a");



    }
    private static LinkedListNode buildLinkedListByString(String s) {
        List<String> nodes = Splitter.on(",").splitToList(s);
        if (nodes == null || nodes.size() == 0) {
            return null;
        }

        LinkedListNode head = new LinkedListNode(nodes.get(0), null);

        LinkedListNode cur = head;

        for (int i=1; i < nodes.size(); i++) {
            LinkedListNode temp = new LinkedListNode(nodes.get(i), null);
            cur.next = temp;
            cur = temp;
        }
        return head;
    }

    private static String linkedListToString(LinkedListNode head) {
        if (head == null) {
            return null;
        }

        List<String> res = Lists.newArrayList();

        while (head != null) {
            res.add(head.value);
            head = head.next;
        }
        return Joiner.on(",").join(res);

    }
}
