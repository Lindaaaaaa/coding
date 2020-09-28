package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lindaliu on 2020-07-03.
 */
// sorting method good to review, O(n) kinda special algorithm
public class LongestConsecutiveSequence {
    public static int longestConsecutive_sorting1(int[] nums) {
        //sorting O(nlogn) [-1,-1,1,2,5,6,7,8,12,13]
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        for (int i=1; i< nums.length; i++) {
            int current = 1;
            while (nums[i] == nums[i-1] + 1 || nums[i] == nums[i-1]) {
                if (nums[i] == nums[i-1] + 1){
                    current++;
                }
                i++;
                if (i >= nums.length) {
                    break;
                }
            }
            longest = Math.max(longest, current);
        }
        return longest;
    }

    public static int longestConsecutive_sorting2(int[] nums) {
        //sorting O(nlogn) [-4,-3,-1,-1,0,1,2,5,6,7,8,12,13]
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                longest = Math.max(count, longest);
                count = 1;
            }
        }
        longest = Math.max(count, longest);
        return longest;
    }

    //[100,4,200,1,3,2]
    // special algorithm, if there set contains num-1, do nothing let num-1 be the sequence starting point
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i< nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 1;
        for (int i: set) {
            if (!set.contains(i - 1)) {
                int j = i;
                while (set.contains(j)) {
                    j ++;
                }
                result = Math.max(result, j-i);
            }
        }
        return result;
    }
}
