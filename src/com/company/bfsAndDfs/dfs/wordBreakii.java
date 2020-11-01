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
    // working solution dfs with memorization
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
