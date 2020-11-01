package com.company.bfsAndDfs.dfs;

/**
 * Created by Lindaliu on 2020-10-31.
 */
import java.util.*;
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (int i=1; i<words.length; i++){
            wordSet.add(words[i-1]);
            if (isWordBreak(words[i], wordSet)) {
                res.add(words[i]);
            }
        }
        return res;
    }
    public boolean isWordBreak(String s, Set<String> wordSet){
        Boolean[] dp = new Boolean[s.length() + 1];
        Arrays.fill(dp, Boolean.FALSE);
        dp[0] = true;
        for(int i = 1; i< s.length()+1; i++) {
            for(int j =0; j< i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
