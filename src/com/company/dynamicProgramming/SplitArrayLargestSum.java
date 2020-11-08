package com.company.dynamicProgramming;

/**
 * Created by Lindaliu on 2020-11-06.
 */
public class SplitArrayLargestSum {
    // dfs with memorization
    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        int[] preSum = new int[length+1];
        preSum[0] =0;
        for (int i= 1; i< length +1; i++) {
            preSum[i] = nums[i-1] + preSum[i-1];
        }
        int[][] visited = new int[length][m+1];
        return dfs(nums, m,0, preSum, visited);
    }

    public int dfs(int[] nums, int m, int start, int[] preSum, int[][] visited) {
        if (m ==1) {
            return preSum[nums.length]- preSum[start];
        }
        if (visited[start][m]!=0) {
            return visited[start][m];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start+1; i< nums.length; i++) {
            int left = preSum[i] - preSum[start];
            int right = dfs(nums, m-1, i, preSum, visited);
            res = Math.min(Math.max(left, right), res);
        }
        visited[start][m] = res;
        return res;
    }

    public int splitArray_dp(int[] nums, int m) {
        //Let dp[i][j] be the min of the largest sum for array [0...i], split into j
        int[][] dp = new int[nums.length][m+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][1] = nums[0];
        for (int i=1; i< nums.length; i++) {
            dp[i][1] = nums[i] + dp[i-1][1];
        }
        for (int i=1; i< nums.length; i++) {
            for (int j =2; j<=m; j++) {
                for (int k=0; k<i; k++) {
                    //dp[i][j] - minimum largest subarray sum for splitting nums[0..i] into j parts
                    // dp[i][1] - dp[k][1], sum between nums[k+1] to nums[i]
                    //dp[k][j-1] - minimum largest subarray sum at index k when m = j-1
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], dp[i][1]-dp[k][1]));
                }
            }
        }
        return dp[nums.length-1][m];
    }

}
