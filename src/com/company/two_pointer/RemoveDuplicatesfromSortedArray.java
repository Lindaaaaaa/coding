package com.company.two_pointer;

/**
 * Created by Lindaliu on 2020-06-29.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length ==0 || nums.length==1){
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while (right< nums.length) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }
}
