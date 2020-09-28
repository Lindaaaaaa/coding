package com.company.two_pointer;

/**
 * Created by Lindaliu on 2020-06-29.
 */
/*
/*** NOt freqeunt but can be reviewed , tricky alg
Given nums = [1,1,1,2,2,3,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        // i is the iterator and j is the index of value to be replaced
        int j = 1;
        int count = 1;
        for (int i=1; i< nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                count =1 ;
            } else {
                count ++;
            }
            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    // not working
    public int removeDuplicates_failed(int[] nums) {
        if (nums.length ==0 || nums.length ==1 || nums.length== 2){
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left]!= nums[right]){
                if (nums[left] == nums[left+1]) {
                    left +=2;
                }
                if (left == right) {
                    break;
                } else {
                    nums[left] = nums[right];
                }
            }
            right ++;
        }
        if (left + 2 <nums.length) {
            return nums[left] == nums[left+2]? left+1 : left +2;
        }
        return left+1;
    }
}
