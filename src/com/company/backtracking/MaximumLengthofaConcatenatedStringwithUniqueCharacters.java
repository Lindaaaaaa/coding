package com.company.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lindaliu on 2020-08-08.
 */
//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/discuss/696020/a-really-easy-Java-DFS-solution.
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    class Solution {
        int length = 0;
        public int maxLength(List<String> arr) {
            helper(arr,0,"");
            return length;
        }

        public void helper(List<String> arr, int index, String path){
            if (isUnique(path)) {
                length = Math.max(path.length(), length);
            }
            if (index == arr.size()) {
                return;
            }
            for (int i = index; i< arr.size(); i++) {
                helper(arr, i+1, path+ arr.get(i));
            }

        }



        private boolean isUnique(String s){
            Set<Character> set=new HashSet<>();
            for(char c:s.toCharArray()){
                if(!set.add(c)){
                    return false;
                }
            }
            return true;
        }
    }
}
