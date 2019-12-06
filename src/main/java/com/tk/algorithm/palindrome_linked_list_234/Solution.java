package com.tk.algorithm.palindrome_linked_list_234;

public class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode cur = head, pre = null;
        while (fast != null && fast.next != null) {

            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != cur.val) {
                return false;
            }
            slow = slow.next;
            cur = cur.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
