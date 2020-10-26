package com.company.bfsAndDfs.bfs;

import java.util.*;

/**
 * Created by Lindaliu on 2020-07-05.
 * VERY IMPORTENT KEEP REVIEWING
 * FIND SHORTEST DISTANCE USING BFS
 */
public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j=0; j< size; j++) {
                String str = queue.poll();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newString = new String(chars);
                        if (set.contains(newString)) {
                            if (visited.contains(newString)) {
                                continue;
                            }
                            if (newString.equals(endWord)) {
                                return level + 1;
                            }
                            visited.add(newString);
                            queue.add(newString);
                        }
                    }
                    chars[i] = temp;
                }
            }
            level ++;
        }
        return 0;
    }
}
