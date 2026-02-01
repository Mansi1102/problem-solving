package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Rules for n-Queen in Chessboard:
1. Every row should have one Queen
2. Every column should have one Queen
3. No two queen can attack each other
 */

public class NQueen {
    public static void main(String[] args) {
        int n=4;
        System.out.println("Queen Placed: " + solveNQueens(n));
    }
    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        boolean[] leftRow = new boolean[n]; // leftRow[row]
        boolean[] lowerDiagonal = new boolean[2*n-1]; // (row+col)
        boolean[] upperDiagonal = new boolean[2*n-1]; // (col - row + n - 1)

        solve(0,n,board,leftRow,lowerDiagonal,upperDiagonal,res);
        return res;
    }

    private static void solve(int col, int n, char[][] board, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal, List<List<String>> res){
        // base case: all columns filled
        if(col==n){
            res.add(construct(board));
            return;
        }

        // try all rows for this column
        for(int row=0;row<n;row++){
            if(!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[col - row + n - 1]){
                // place queen
                board[row][col]='Q';
                leftRow[row]=true;
                lowerDiagonal[row+col]=true;
                upperDiagonal[col-row+n-1]=true;

                // move to next column
                solve(col+1,n,board,leftRow,lowerDiagonal,upperDiagonal,res);

                // backtrack
                board[row][col]='.';
                leftRow[row]=false;
                lowerDiagonal[row+col]=false;
                upperDiagonal[col-row+n-1]=false;
            }
        }
    }
    private static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] r : board) {
            list.add(new String(r));
        }
        return list;
    }
}

/*
Complexity
Time: O(N!)
Space: O(N²) (board + recursion + arrays)
 */