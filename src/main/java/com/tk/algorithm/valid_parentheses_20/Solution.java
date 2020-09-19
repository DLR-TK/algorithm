package com.tk.algorithm.valid_parentheses_20;

import java.util.Stack;

public class Solution {

    //错误代码
//    public boolean isValid2(String s) {
//        char[] chars = s.toCharArray();
//        int count1 = 0;
//        int count2 = 0;
//        int count3 = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == '(' || chars[i] == ')') {
//                count1 += chars[i] == '(' ? 1 : -1;
//            } else if (chars[i] == '{' || chars[i] == '}') {
//                count2 += chars[i] == '{' ? 1 : -1;
//            } else {
//                count3 += chars[i] == '[' ? 1 : -1;
//            }
//            if (count1 < 0 || count2 < 0 || count3 < 0) {
//                return false;
//            }
//        }
//        return count1 == 0 && count2 == 0 && count3 == 0;
//    }



    //栈
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

    //单变量 单括号
    public boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count += chars[i] == '(' ? 1 : -1;
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
