package com.tk.algorithm.add_two_numbers_445;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度
     * 空间复杂度
     * @param head
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int size1 = listSize(l1);
        int size2 = listSize(l2);

        if (size1 > size2) {
            l2 = listAddZero(l2,size1 - size2);
        }else {
            l1 = listAddZero(l1,size2 - size1);
        }

        if (listAddNumbers(l1, l2) == 1) {
            ListNode cur = new ListNode(1);
            cur.next = l1;
            l1 = cur;
        }
        return l1;
    }

    public int listSize(ListNode head) {

        int length = 0;
        if (head == null) {
            return length;
        }
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public ListNode listAddZero(ListNode head, int n) {

        for (int i = 0; i < n; i++) {
            ListNode cur = new ListNode(0);
            cur.next = head;
            head = cur;
        }
        return head;
    }

    private int listAddNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        if (l1 != null) {
            l1.val = l1.val + l2.val +
                    listAddNumbers(l1.next, l2.next);
            carry = l1.val / 10;
            l1.val = l1.val % 10;
        }

        return carry;
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
        int[] arr2 = {1,2,3};

        int n = arr.length;
        int n2 = arr2.length;

        Solution solution = new Solution();
        ListNode head = solution.createListNode(arr, n);
        ListNode head2 = solution.createListNode(arr2, n2);

        ListNode head3 = solution.addTwoNumbers(head, head2);
        solution.printLinkedList(head3);

//        solution.printLinkedList(head2);
//        System.out.println(solution.listSize(head2));
//
//        ListNode head3 = solution.listAddZero(head2, n - n2);
//        solution.printLinkedList(head3);
//        System.out.println(solution.listSize(head3));
    }
}
