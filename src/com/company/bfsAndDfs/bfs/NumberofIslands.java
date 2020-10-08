package com.company.bfsAndDfs.bfs;

/**
 * Created by Lindaliu on 2020-10-04.
 */
public class NumberofIslands {
    public int numIslands_dfs(char[][] grid) {
        int res = 0;
        if (grid.length == 0) {return 0;}
        int nrows = grid.length;
        int ncols = grid[0].length;
        for (int i=0; i< nrows; i++) {
            for (int j =0; j< ncols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);

                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i>=0 && i<grid.length && j>=0 && j<grid[0].length) {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                dfs(grid, i-1, j);
                dfs(grid, i+1, j);
                dfs(grid, i, j+1);
                dfs(grid, i, j-1);
            }
        }
    }
}
