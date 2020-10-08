package com.company.bfsAndDfs.bfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lindaliu on 2020-10-05.
 * https://leetcode.com/problems/rotting-oranges/
 */
public class rottingOranges {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) freshOranges++;
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

            }
        }
        if (freshOranges == 0) return 0;
        int[][] dirs = {{0,1},{0, -1},{1,0},{-1, 0}};

        int level = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshOranges--;
                        q.offer(new int[]{newX, newY});
                    }
                }


            }

            level++;
        }

        return freshOranges == 0? level : -1;
    }
}
