package com.company.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lindaliu on 2020-07-10.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        backTracking(res, s, new ArrayList<>(), 0);
        return res;
    }

    public void backTracking(List<List<String>> res, String s, List<String> track, int start){
        if (start == s.length()){
            res.add(new ArrayList<>(track));
        }
        for(int hi = start; hi< s.length(); hi++) {
            if (isPalindrome(s,start, hi)){
                track.add(s.substring(start, hi+1));
                backTracking(res, s, track, hi + 1);
                track.remove(track.size()-1);
            }
        }
    }

    public boolean  isPalindrome(String s, int lo, int hi) {
        while (lo< hi) {
            if (s.charAt(hi)!=s.charAt(lo)) {
                return false;
            } else {
                lo++;
                hi--;
            }
        }
        return true;
    }
}
