package com.tk.algorithm.vector;

public class Main {

//    public static void main(String[] args) {
//
//        for (int i = 10; i <= 16; i++) {
//
//            int n = (int)Math.pow(2, i);
//
//            double start = System.currentTimeMillis();
//
//            MyVector<Integer> vector = new MyVector<>(Integer.class);
//
//            for (int j = 0; j < n; j++) {
//                vector.pushBack(j);
//            }
//            for (int j = 0; j < n; j++) {
//                vector.popBack(j);
//            }
//
//            double end = System.currentTimeMillis();
//
//            System.out.print(2*n + " operations: ");
//            System.out.println((end - start)/1000);
//        }
//    }

    public static void main(String[] args) {
        MyVector<Integer> vector = new MyVector<>(Integer.class);
        for (int i = 0; i < 21; i++) {
            vector.pushBack(i);
        }

        vector.popBack();
        System.out.println(vector.toString());
    }
}
