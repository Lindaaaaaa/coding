package com.company;

import java.util.*;

public class Main {
    public static List<List<Integer>> res = new LinkedList<>();
    public static void  main(String[] args) {
        int[] nums= new int[] {1,2,3};
        Arrays.sort(nums);
        backTracking(nums, new ArrayList<Integer>(), 0);
    }



    public static void backTracking(int[] nums, List<Integer> track, int index) {
        res.add(new ArrayList<Integer>(track));
        for (int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            backTracking(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
