package com.tk.algorithm.formed_by_characters_1160;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    public int countCharacters(String[] words, String chars) {
//
//        if (chars.length() == 0)
//            return 0;
//        Map<Character, Integer> mapChars = new HashMap<>();
//        int num = 0;
//
//        for (int i = 0; i < chars.length(); i++) {
//            if (mapChars.get(chars.charAt(i)) == null) {
//                mapChars.put(chars.charAt(i), 1);
//            } else {
//                mapChars.put(chars.charAt(i), mapChars.get(chars.charAt(i)) + 1);
//            }
//        }
//
//        //System.out.println(mapChars);
//
//        for (int i = 0; i < words.length; i++) {
//            Map<Character, Integer> mapWords = new HashMap<>();
//            int l = words[i].length();
//            for (int j = 0; j < l; j++) {
//                if (mapWords.get(words[i].charAt(j)) == null) {
//                    mapWords.put(words[i].charAt(j), 1);
//                } else {
//                    mapWords.put(words[i].charAt(j), mapWords.get(words[i].charAt(j)) + 1);
//                }
//            }
//            //System.out.println(mapWords);
//
//            for (Character key : mapWords.keySet()) {
//                int v = mapWords.get(key);
//                if (mapChars.get(key) == null || v > mapChars.get(key)) {
//                    l = 0;
//                    break;
//                }
//            }
//            num = num + l;
//        }
//        return num;
//    }

    public int countCharacters(String[] words, String chars) {
        int[] recodeC = new int[26];
        for(char c : chars.toCharArray()) {
            recodeC[c - 'a'] += 1;
        }
        int res = 0;
        flag : for(String word : words) {
            int[] recodeW = new int[26];
            for(char w : word.toCharArray()) {
                recodeW[w - 'a'] += 1;
            }
            for(int i = 0; i < 26; i++) {
                if(recodeW[i] > recodeC[i]) {
                    continue flag;
                }
            }
            res += word.length();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        int n = solution.countCharacters(words, chars);
        System.out.println(n);
    }
}
