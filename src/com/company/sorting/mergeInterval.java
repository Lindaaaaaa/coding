package com.company.sorting;

import java.util.Arrays;
import java.util.*;

/**
 * Created by Lindaliu on 2020-08-04.
 */

// sort first and create a new Linkedlist to store the result
public class mergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        for(int[]interval: intervals) {
            if (result.isEmpty() || interval[0] > result.get(result.size() -1)[1]) {
                result.add(interval);
            } else {
                result.get(result.size()-1)[1] = Math.max(interval[1], result.get(result.size() -1)[1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
