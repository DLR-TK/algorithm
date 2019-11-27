package com.tk.algorithm.sort_colors75;

@SuppressWarnings("all")
public class Solution {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(k) k为元素取值范围
     * @param nums
     */
    public void sortColors1(int[] nums) {

        int[] count = new int[3];//存放0,1,2三个频率
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >=0 && nums[i] <= 2);
            count[nums[i]]++;
        }
        
        int index = 0;
        for (int i = 0; i < count[0] ; i++) {
            nums[index++] = 0;
        }

        for (int i = 0; i < count[1] ; i++) {
            nums[index++] = 1;
        }

        for (int i = 0; i < count[2] ; i++) {
            nums[index++] = 2;
        }
    }

    public void sortColors2(int[] nums) {

        int zero = -1; //nums[0...zero] == 0
        int two = nums.length; //nums[two...n-1] == 2

        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            }else if (nums[i] == 2) {
                two--;
                if (two != i) {
                    nums[i] = nums[i] ^ nums[two];
                    nums[two] = nums[i] ^ nums[two];
                    nums[i] = nums[i] ^ nums[two];
                }
            }else {
                assert (nums[i] == 0);
                zero++;
                if (zero != i) {
                    nums[i] = nums[i] ^ nums[zero];
                    nums[zero] = nums[i] ^ nums[zero];
                    nums[i] = nums[i] ^ nums[zero];
                }
                i++;
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {0};
        Solution solution = new Solution();
        solution.sortColors2(nums);
        for (int num:nums) {
            System.out.print(num);
        }
    }
}
