package com.AmazoOA;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/373202
 * Created by Lindaliu on 2020-09-30.
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value.
 * Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible.
 * Return a list of ids of selected elements. If no pair is possible, return an empty list.
 * Input:
 a = [[1, 2], [2, 4], [3, 6]]
 b = [[1, 2]]
 target = 7

 Output: [[2, 1]]

 Explanation:
 There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair
 */
public class OptimalUtilization {
    public static void main(String[] args) {
        List<int[]> a = new LinkedList<>();
        a.add(new int[]{1, 3});
        a.add(new int[]{2, 5});
        a.add(new int[]{3, 7});
        a.add(new int[]{4, 10});
        List<int[]> b = new LinkedList<>();
        b.add(new int[]{1, 2});
        b.add(new int[]{2, 3});
        b.add(new int[]{3, 4});
        b.add(new int[]{4, 5});
        List<int[]> res = solve(a, b, 10);
        System.out.print(solve(a, b, 10));


    }

    public static List<int[]> solve(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, (i, j) -> i[1] - j[1]);
        Collections.sort(b, (i, j) -> i[1] - j[1]);
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum > target) {
                --j;
            } else {
                if (max <= sum) {
                    if (max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});

                    int index = j - 1;
                    // this loop if for checking duplicates values
                    //int[][] a1 = {{1, 5}, {2, 5}};
                    //int[][] b1 = {{1, 5}, {2, 5}};
                    while (index >= 0 && b.get(index)[1] == b.get(index + 1)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                ++i;
            }
        }
        return result;
    }
}
