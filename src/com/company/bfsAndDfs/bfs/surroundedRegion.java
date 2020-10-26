package com.company.bfsAndDfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lindaliu on 2020-07-06.
 */
public class surroundedRegion {
    // bfs solution
    public void solve(char[][] board) {
        if (board == null || board.length ==0){
            return;
        }
        int nrow = board.length;
        int ncol = board[0].length;
        int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i=0; i< nrow; i++) {
            for (int j=0; j< ncol; j++) {
                if ((i ==0 || j ==0 || i == nrow-1 || j == ncol-1) && board[i][j]=='O') {
                    Queue<Point> queue = new LinkedList();
                    queue.add(new Point(i,j));
                    board[i][j] = 'B';
                    while(!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k =0; k< 4; k++) {
                            int x = point.x + direction[k][0] ;
                            int y = point.y + direction[k][1];
                            if (x>=0 && y>=0 && x< nrow && y<ncol && board[x][y] == 'O') {
                                board[x][y] = 'B';
                                queue.add(new Point(x, y));
                            }
                        }
                    }
                }
            }
        }

        for (int i=0; i< nrow; i++) {
            for (int j=0; j<ncol; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] ='O';
                }else if (board[i][j] == 'O') {
                    board[i][j] ='X';
                }
            }
        }
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
