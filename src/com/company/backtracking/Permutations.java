package com.company.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lindaliu on 2020-07-08.
 * result = []
 def backtrack(路径, 选择列表):
 if 满足结束条件:
 result.add(路径)
 return

 for 选择 in 选择列表:
 做选择
 backtrack(路径, 选择列表)
 撤销选择


 for 选择 in 选择列表:
 # 做选择
 将该选择从选择列表移除
 路径.add(选择)
 backtrack(路径, 选择列表)
 # 撤销选择
 路径.remove(选择)
 将该选择再加入选择列表
 */
public class Permutations {
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
