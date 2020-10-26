package com.company.bfsAndDfs.bfs;

import java.util.*;

/**
 * Created by Lindaliu on 2020-10-05.
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpentheLock {
    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        int steps = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
        /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
            /* 判断是否到达终点 */
                if (cur.equals(target)) {
                    return steps;
                }
                if (set.contains(cur)) {
                    continue;
                }

            /* 将一个节点的相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
