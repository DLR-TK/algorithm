package com.tk.algorithm.majority_element_169;


import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

@SuppressWarnings("all")
public class Solution {

    public int majorityElement(int[] nums) {

//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i : nums) {
//            if (map.containsKey(i)) {
//                map.put(i, map.get(i) + 1);
//            } else {
//                map.put(i,1);
//            }
//        }
//
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
//                (a, b) -> map.get(a) - map.get(b)
//        );
//        for (int key : map.keySet()) {
//            priorityQueue.add(key);
//        }
//
//        return priorityQueue.peek();

        Stack<Integer> stack = new Stack<>();
        for(int i : nums){
            if(stack.empty() || i == stack.peek()){
                stack.push(i);
            }else{
                stack.pop();
            }
        }
        return stack.peek();
    }
}
