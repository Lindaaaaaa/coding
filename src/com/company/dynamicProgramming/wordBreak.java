package com.company.dynamicProgramming;

/**
 * Created by Lindaliu on 2020-10-12.
 */
import java.util.*;
public class wordBreak {
    // brute force, check wordDict contains s[i,j] and recursive on the rest of string
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return isBreak(s, wordSet, 0);
    }

    public boolean isBreak(String s, Set<String> wordSet, int start) {
        if (start ==s.length()) {
            return true;
        }
        for (int i = start+1; i< s.length()+1; i++) {
            if (wordSet.contains(s.substring(start, i)) && isBreak(s, wordSet, i)) {
                return true;
            }
        }
        return false;
    }

    // dp solution
    // dp[i] represents if string (0,i) can be made up by word Dict
    // if word end with char i can be broken + the rest of string is contained in wordDict
    public boolean wordBreak_dp(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i =1; i< s.length()+1; i++) {
            for (int j = 0; j< i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
