package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lindaliu on 2020-07-10.
 * https://www.youtube.com/watch?v=irFtGMLbf-s
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(res, candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }

    public void backTracking(List<List<Integer>> res, int[] candidates, List<Integer> track, int target, int start){
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(track));
        }
        for (int i=start; i< candidates.length; i++) {
            track.add(candidates[i]);
            backTracking(res, candidates, track, target - candidates[i], i);
            track.remove(track.size()-1);
        }
    }
}
