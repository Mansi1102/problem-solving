package Graph;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int[][] vis = new int[n][m];

        // Mark boundary-connected land
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0)
                dfs(0, j, vis, grid, n, m, delRow, delCol);

            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0)
                dfs(n - 1, j, vis, grid, n, m, delRow, delCol);
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0)
                dfs(i, 0, vis, grid, n, m, delRow, delCol);

            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0)
                dfs(i, m - 1, vis, grid, n, m, delRow, delCol);
        }

        // Count enclave cells
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int row, int col, int[][] vis, int[][] grid,
                    int n, int m, int[] delRow, int[] delCol) {

        vis[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    vis[newRow][newCol] == 0 &&
                    grid[newRow][newCol] == 1) {

                dfs(newRow, newCol, vis, grid, n, m, delRow, delCol);
            }
        }
    }
}
