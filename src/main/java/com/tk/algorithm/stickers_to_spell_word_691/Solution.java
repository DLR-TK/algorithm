package com.tk.algorithm.stickers_to_spell_word_691;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minStickers(String[] stickers, String target) {

        if (stickers.length == 0 || target == null) {
            return 0;
        }

        int n = stickers.length;
        int[][] cache = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] chars = stickers[i].toCharArray();
            for (char c : chars) {
                cache[i][c - 'a']++;
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("", 0);
        return process(map, cache, target);
    }

    private int process(HashMap<String, Integer> map, int[][] cache, String target) {

        if (map.containsKey(target)) {
            return map.get(target);
        }

        int res = Integer.MAX_VALUE;
        int n = cache.length;
        int[] targetCache = new int[26];
        char[] chars = target.toCharArray();
        for (char c : chars) {
            targetCache[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (cache[i][chars[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetCache[j] > 0) {
                    for (int k = 0; k < Math.max(0, targetCache[j] - cache[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            String s = sb.toString();
            int tmp = process(map, cache, s);
            if (tmp != -1) {
                res = Math.min(res, tmp + 1);
            }
        }

        map.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return map.get(target);
    }
}
