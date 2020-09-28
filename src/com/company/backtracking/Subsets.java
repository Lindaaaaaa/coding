package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lindaliu on 2020-07-08.
 *  def backtrack(路径, 选择列表):
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

//https://www.youtube.com/watch?v=VdnvmfzA1pw

public class Subsets {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, new ArrayList<Integer>(), 0);
        return res;
    }

    public void backTracking(int[] nums, List<Integer> track, int index) {
        res.add(new ArrayList<Integer>(track));
        for(int i = index; i< nums.length; i++) {
            track.add(nums[i]);
            backTracking(nums, track, i +1);
            track.remove(track.size()-1);
        }
    }
}
