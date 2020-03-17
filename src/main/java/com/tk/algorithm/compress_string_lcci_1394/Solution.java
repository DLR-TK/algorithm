package com.tk.algorithm.compress_string_lcci_1394;

public class Solution {

//    public String compressString(String S) {
//
//        if (S.length() == 0)
//            return "";
//
//        StringBuilder res = new StringBuilder();
//        int num = 1;
//        res.append(S.charAt(0));
//        for (int i = 1; i < S.length(); i++) {
//            if (S.charAt(i) == S.charAt(i - 1)) {
//                num++;
//            } else {
//                res.append(num);
//                num = 1;
//                res.append(S.charAt(i));
//            }
//        }
//        res.append(num);
//
//        if (res.length() >= S.length())
//            return S;
//
//        return res.toString();
//    }

    public String compressString(String S) {

        if (S.length() == 0)
            return "";

        StringBuilder res = new StringBuilder();

        int num = 1;
        res.append(S.charAt(0));
        int l = 0;

        for (int r = 1; r < S.length(); r++) {
            if (S.charAt(r) == S.charAt(l)) {
                num++;
            } else {
                res.append(num);
                num = 1;
                l = r;
                res.append(S.charAt(r));
            }
        }
        res.append(num);

        if (res.length() >= S.length())
            return S;

        return res.toString();
    }

}
