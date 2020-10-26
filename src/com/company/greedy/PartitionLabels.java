package com.company.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lindaliu on 2020-10-10.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        // record character i last index in the string
        int[] pos = new int[26];
        for (int i =0; i<S.length(); i++){
            pos[S.charAt(i) -'a'] = i;
        }
        List<Integer> res = new LinkedList();
        for (int i =0; i<S.length(); i++){
            int end = pos[S.charAt(i) -'a'];
            for (int j = i+1; j<end; j++) {
                int newEnd = pos[S.charAt(j) -'a'];
                if (newEnd > end) {
                    end = newEnd;
                }
            }
            res.add(end- i+1);
            i = end;
        }
        return res;
    }

    public List<Integer> partitionLabels_answer(String S) {
        int[] map= new int[26];
        for (int i=0; i<S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> res = new LinkedList<Integer>();
        for (int i=0; i<S.length(); i++) {
            end = Math.max(end, map[S.charAt(i)-'a']);
            if (end == i) {
                res.add(end-start+1);
                start = end + 1;
            }
        }
        return res;
    }
}
