package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixNearByDistance {
    public static void main(String[] args) {
        int mat[][] = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] res = updateMatrix(mat);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
    private static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dis = mat;   // using same matrix

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Push all 0s, mark 1s as -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        dis[newRow][newCol] == -1) {

                    dis[newRow][newCol] = dis[row][col] + 1;  // ✅ FIX
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return dis;
    }
}
