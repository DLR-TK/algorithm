package com.tk.algorithm.valid_parentheses20;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }else {
                if (stack.size() == 0) {
                    return false;
                }
                char c = stack.peek();
                stack.pop();

                char match;
                if (s.charAt(i) == ')') {
                    match = '(';
                }else if (s.charAt(i) == ']') {
                    match = '[';
                }else {
                    assert (s.charAt(i) == '}');
                    match = '{';
                }

                if (c != match) {
                    return false;
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }
}
