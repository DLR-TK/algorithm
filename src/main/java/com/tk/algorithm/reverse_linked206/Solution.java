package com.tk.algorithm.reverse_linked206;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public  ListNode createListNode(int[] arr, int n) {

        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);

        ListNode curNode = head;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public void printLinkedList(ListNode head) {

        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        Solution solution = new Solution();
        ListNode head = solution.createListNode(arr, n);
        solution.printLinkedList(head);

        ListNode head2 = solution.reverseList(head);
        solution.printLinkedList(head2);
    }
}
