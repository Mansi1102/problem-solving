package Graph;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int[][] vis = new int[n][m];

        // Check first and last row
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, n, m, delRow, delCol);
            }
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, n, m, delRow, delCol);
            }
        }

        // Check first and last column
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, n, m, delRow, delCol);
            }
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, n, m, delRow, delCol);
            }
        }

        // Flip surrounded regions
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(int row, int col, int[][] vis, char[][] board,
                    int n, int m, int[] delRow, int[] delCol) {

        vis[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    vis[newRow][newCol] == 0 &&
                    board[newRow][newCol] == 'O') {

                dfs(newRow, newCol, vis, board, n, m, delRow, delCol);
            }
        }
    }
}
