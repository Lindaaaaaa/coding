package com.company.dynamicProgramming;

/**
 * Created by Lindaliu on 2020-10-10.
 */
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] =1;
        for(int i=1; i< nums.length; i++) {
            left[i] = left[i-1] *nums[i-1];
        }
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        right[nums.length-1] =1;
        for(int i =nums.length-1; i>=1; i--) {
            res[i] = left[i] *right[i];
            right[i-1] = right[i] * nums[i];
        }
        return res;
    }

    public int[] productExceptSelf_space_1_solution(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i =1; i<res.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for(int j= res.length-1; j>=0; j--){
            res[j] = res[j] * right;
            right = right * nums[j];
        }
        return res;
    }
}
