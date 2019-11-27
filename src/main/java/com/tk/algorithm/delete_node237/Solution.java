package com.tk.algorithm.delete_node237;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public void deleteNode(ListNode node) {

        if (node == null) {
            return;
        }

        if (node.next == null) {
            node = null;
        }
        node.val = node.next.val;
        node.next = node.next.next;
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
