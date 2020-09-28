package com.company.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by Lindaliu on 2020-07-14.
 */
public class LongestIncreasingSubsequence {
    // dp[i] is the max length of subsequence that ends with i
    // to calculate dp[j], needs to check all dp[i] where i<j and dp[i]<dp[j]
    public int lengthOfLIS_dp(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i< dp.length; i++) {
            int maxLength = 1;
            for (int j = 0; j < i; j ++) {
                if (dp[j] < dp[i]) {
                    maxLength = Math.max(maxLength, dp[j] + 1);
                }
            }
            dp[i] = maxLength;
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

}
