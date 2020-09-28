package com.company.two_pointer;

/**
 * Created by Lindaliu on 2020-07-04.
 */
public class moveZeros {
    // same as remove element, no review
    public void moveZeroes(int[] nums) {
        int i =0;
        for (int j =0; j< nums.length; j++) {
            if (nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        for (int k = i; k< nums.length; k++) {
            nums[k] = 0;
        }
    }
}
