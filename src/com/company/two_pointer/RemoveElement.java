package com.company.two_pointer;

/**
 * Created by Lindaliu on 2020-07-04.
 */
public class RemoveElement {
    // review
    // fill in number in index i
    public int removeElement(int[] nums, int val) {
        //[1,1, 1,1,2,2,3,0,4,2]
        int i=0;
        for (int j=0; j< nums.length; j++) {
            if (nums[j]!= val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
