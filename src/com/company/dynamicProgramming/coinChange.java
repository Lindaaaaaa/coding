package com.company.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by Lindaliu on 2020-07-11.
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 */
public class coinChange {
    // improvement, use max value as initialization
    public int coinChangeOptimal(int[] coins, int amount) {
        // don't initialize with Integer.maxValue, it will casue overflow when + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i< dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                int target = i - coin;
                if (target < 0) {
                    continue;
                } else if (target == 0) {
                    dp[i] = 1;
                    break;
                } else {
                    if (dp[target] == -1) {
                        continue;
                    }
                    if (dp[i] == -1) {
                        dp[i] = dp[target] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[target] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }

}
