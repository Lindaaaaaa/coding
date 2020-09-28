package com.company.bfsAndDfs.bfs.dfs;

import java.util.*;

/**
 * Created by Lindaliu on 2020-06-28.
 */
public class wordBreak {
    private static boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i< s.length()+1; i++) {
            for(int j =0; j< i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak2(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        return dfs(s,set, new HashMap<String, Boolean>());
    }

    private static boolean dfs(String s, Set<String> set, Map<String, Boolean> map) {
        if (s.equals("")){
            return true;
        }
        if (map.containsKey(s)){
            return map.get(s);
        }
        for(int i=1; i<=s.length();i++){
            if (set.contains(s.substring(0,i))
                    && dfs(s.substring(i, s.length()), set, map)){
                map.put(s.substring(0,i), true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public static boolean wordBreak_failed(String s, List<String> wordDict){
//        int a = s.indexOf("apple");
//        int b = s.indexOf("pen");
//        System.out.println(a + "/" + b);
        if (s==null ||s.length()==0) {
            return false;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            String current = queue.poll();
            int failing = 0;
            for (String word: wordDict){
                if (current.equals(word)){
                    break;
                }
                int index = current.indexOf(word);
                if(index!=-1){
                    int firstPartEnd = index-1;
                    int secondPartStart = index+ word.length();
                    if (firstPartEnd<0){
                        queue.add(current.substring(secondPartStart, current.length()));
                        break;
                    }
                    if(secondPartStart >= current.length()){
                        queue.add(current.substring(0,firstPartEnd+1));
                        break;
                    }
                    queue.add(current.substring(0,firstPartEnd+1));
                    queue.add(current.substring(secondPartStart, current.length()));
                } else {
                    failing ++;
                    if (failing == wordDict.size()){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
