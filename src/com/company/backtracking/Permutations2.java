package com.company.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lindaliu on 2020-07-10.
 */
public class Permutations2 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        backTracking(nums, track);
        return res;
    }

    public void backTracking(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            // note: cannot just do res.add(track), because track is going to be modified latter on
            // although java is pass by value, but list is not a primitive type, so track stores address of actual array
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i =0; i < nums.length; i++) {

        }
        for (int num: nums) {
            if (track.contains(num)){
                continue;
            }
            track.add(num);
            backTracking(nums, track);
            track.remove(track.indexOf(num));
        }
    }
}
