package Recursion;

public class sudokoSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // find empty cell
                if (board[row][col] == '.') {

                    // try digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board))
                                return true;

                            // backtrack
                            board[row][col] = '.';
                        }
                    }

                    // no valid number found
                    return false;
                }
            }
        }

        // board completely filled
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {

        // check row & column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }

        // check 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num)
                    return false;
            }
        }

        return true;
    }
}
