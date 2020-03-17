package com.tk.algorithm.partition_array_into_three_parts_1013;

public class Solution {

    public boolean canThreePartsEqualSum(int[] A) {

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        if (sum % 3 != 0)
            return false;

        int l = 0;
        int r = A.length - 1;
        int lSum = A[l];
        int rSum = A[r];

        while (l + 1 < r) {

            if (lSum == sum / 3 && rSum == sum /3 ) {
                return true;
            }
            if (lSum != sum/3) {
                l++;
                lSum += A[l];
            }
            if (rSum != sum/3) {
                r--;
                rSum += A[r];
            }
        }
        return false;
    }

//    public boolean canThreePartsEqualSum(int[] A) {
//
//        int sum = 0;
//        for (int i : A) {
//            sum += i;
//        }
//
//        if (sum % 3 != 0)
//            return false;
//
//        int s = 0;
//        int freq = 0;
//
//        for(int i : A) {
//            s += i;
//            if (s == sum/3) {
//                s = 0;
//                freq++;
//            }
//        }
//
//        return freq >= 3;
//    }

//    public boolean canThreePartsEqualSum(int[] A) {
//
//        int sum = 0;
//        for(int i : A){
//            sum += i;
//        }
//        if(sum%3 != 0){
//            return false;
//        }
//
//        int left = 0;
//        int leftSum = A[left];
//        int right = A.length - 1;
//        int rightSum = A[right];
//
//        while(left + 1 < right){
//            if(leftSum == sum/3 && rightSum == sum/3){
//                return true;
//            }
//            if(leftSum != sum/3){
//                leftSum += A[++left];
//            }
//            if(rightSum != sum/3){
//                rightSum += A[--right];
//            }
//        }
//        return false;
//    }
}
