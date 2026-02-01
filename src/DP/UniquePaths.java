package DP;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("Unique Paths: " + uniquePaths(m,n));
    }

    private static int uniquePaths(int m, int n) {
        // Create a 2D DP array filled with zeros
        int[][] dp = new int[m][n];

        // Initialize the rightmost column and bottom row to 1
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m-1][j] = 1;
        }

        // Fill in the DP array bottom-up
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        // Return the result stored in the top-left corner
        return dp[0][0];
    }

        private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;

            int dp[][] = new int[n][m];

            // If destination is blocked
            if (obstacleGrid[n-1][m-1] == 1) return 0;

            // Last column
            for (int i = n - 1; i >= 0; i--) {
                if (obstacleGrid[i][m - 1] == 1) break;
                dp[i][m - 1] = 1;
            }

            // Last row
            for (int j = m - 1; j >= 0; j--) {
                if (obstacleGrid[n - 1][j] == 1) break;
                dp[n - 1][j] = 1;
            }

            // Fill dp table
            for (int i = n - 2; i >= 0; i--) {
                for (int j = m - 2; j >= 0; j--) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i+1][j] + dp[i][j+1];
                    }
                }
            }

            return dp[0][0];
        }
}

/*
Bottom-Up Dynamic Programming:
Step 1: Initialize the DP Table

Create a 2D DP (dynamic programming) table of size m x n to store the number of unique paths for each cell.
Initialize the rightmost column and bottom row of the DP table to 1 because there's only one way to reach each cell in those rows/columns (by moving all the way right or all the way down).
Step 2: Fill in the DP Table

Start from the second-to-last row and second-to-last column (i.e., i = m - 2 and j = n - 2).
For each cell (i, j) in the grid:
Calculate the number of unique paths to reach (i, j) as the sum of the unique paths from the cell below (i+1, j) and the cell to the right (i, j+1). Use this formula: dp[i][j] = dp[i+1][j] + dp[i][j+1].
Continue filling in the DP table row by row and column by column until you reach the top-left corner (dp[0][0]).
Step 3: Return the Result

Return the value stored in the top-left corner of the DP table (dp[0][0]), which represents the number of unique paths from the top-left corner to the bottom-right corner.

Time Complexity (TC): The bottom-up approach fills in the DP table iteratively, visiting each cell once. There are m rows and n columns in the grid, so the TC is O(m * n).
Space Complexity (SC): The space complexity is determined by the DP table, which is of size m x n. Therefore, the SC is O(m * n) to store the DP table.
 */

/*
-----------------------------------------------------------------------------------------------------------------------
Unique Path2 -
Method name: uniquePathsWithObstacles()
 */