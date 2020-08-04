package com.tk.algorithm.morris;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Morris {

    public static void morris(Node head) {
        if (head == null) {
            return;
        }

        Node cur = head;
        Node mostRight = null;
        while (cur != null) {

            mostRight = cur.left;
            //判断是否有左树
            if (mostRight != null) {
                //找到最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //第一次到达最右，让最右节点右孩子指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { //mostRight.right == cur 第二次到达，将右孩子指向空 cur = cur.right
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }

        Node cur = head;
        Node mostRight = null;
        while (cur != null) {

            mostRight = cur.left;
            //判断是否有左树
            if (mostRight != null) {
                //找到最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //第一次到达最右，让最右节点右孩子指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.value);
                    cur = cur.left;
                    continue;
                } else { //mostRight.right == cur 第二次到达，将右孩子指向空 cur = cur.right
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    public static void morrisIn(Node head) {
        List<Node> res = new ArrayList<>();
        if (head == null) {
            return;
        }

        Node cur = head;
        Node mostRight = null;
        while (cur != null) {

            mostRight = cur.left;
            //判断是否有左树
            if (mostRight != null) {
                //找到最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //第一次到达最右，让最右节点右孩子指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { //mostRight.right == cur 第二次到达，将右孩子指向空 cur = cur.right
                    mostRight.right = null;
                }
            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
