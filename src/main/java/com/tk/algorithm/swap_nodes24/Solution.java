package com.tk.algorithm.swap_nodes24;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            pre.next = node2;

            pre = node1;
        }

        return dummyHead.next;
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

    }
}
