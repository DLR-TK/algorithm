package com.tk.algorithm.letter_combinations_17;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Solution {

    private String letterMap[] = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    private List<String> res = new ArrayList<>();


    /**
     * 时间复杂度 O(2^n)    3^n
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        if (digits.equals("")) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 寻找和digits[index]匹配的字母，获得digits[0...index]翻译得到的组合
     * @param digits
     * @param index
     * @param s 保存此时从digits[0...index-1]翻译得到的一个字母字符串
     */
    private void findCombination(String digits, int index, String s) {

        System.out.println(index + " : " + s); //调试

        if (index == digits.length()) {
            res.add(s);
            System.out.println("get " + s + " , return"); //调试
            return;
        }
        char c = digits.charAt(index);
        assert (c >= '0' && c <= '9' && c != '1');
        String letters = letterMap[c - '0'];

        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "] = " + c + " , use " + letters.charAt(i)); //调试
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

        System.out.println("digits[" + index + "] = " + c + " complete, return"); //调试
        return;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        List<String> res = solution.letterCombinations("234");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
