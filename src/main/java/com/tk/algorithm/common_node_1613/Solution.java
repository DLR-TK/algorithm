package com.tk.algorithm.common_node_1613;

import java.util.HashSet;

public class Solution {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        HashSet<ListNode> nodes = new HashSet<>();

        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodes.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? p1.next : headB;
            p2 = p2 == null ? p2.next : headA;
        }

        return p1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
