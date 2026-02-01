package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int grid[][] = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int res = orangesRotting(grid);
        System.out.println("Min no. of minutes: " + res);
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int freshCounter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    freshCounter++;
                }
            }
        }
        int count = 0;
        int tm = 0;
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(tm, t);
            q.remove();
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    q.add(new Pair(newRow, newCol, t + 1));
                    vis[newRow][newCol] = 2;
                    count++;
                }
            }
        }
        if (count != freshCounter) return -1;
        return tm;
    }
}

    class Pair{
        int row;
        int col;
        int time;

        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }

//Time Complexity: O(n × m)
//Space Complexity: O(n × m)
