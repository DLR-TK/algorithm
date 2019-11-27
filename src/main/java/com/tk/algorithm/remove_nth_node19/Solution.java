package com.tk.algorithm.remove_nth_node19;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode l = dummyHead;
        ListNode r = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            r = r.next;
        }

        while (r != null) {
            l = l.next;
            r = r.next;
        }

        ListNode delNode = l.next;
        l.next = delNode.next;
        delNode.next = null;

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
