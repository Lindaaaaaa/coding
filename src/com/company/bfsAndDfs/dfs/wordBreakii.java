package com.company.bfsAndDfs.dfs;

/**
 * Created by Lindaliu on 2020-10-14.
 */
import java.util.*;
public class wordBreakii {
    List<String> res = new LinkedList<String>();

    public List<String> wordBreak_not_working_backtrack(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        helper(s, wordSet, "", 0);
        return res;
    }

    public void helper(String s, Set wordSet, String current, int start) {
        if (start == s.length()) {
            res.add(current);
            return;
        }
        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (wordSet.contains(sub)) {
                if (current == "") {
                    helper(s, wordSet, current + sub, end + 1);
                } else {
                    helper(s, wordSet, current + " " + sub, end + 1);
                }
            }
        }
    }
}
