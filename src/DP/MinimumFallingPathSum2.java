package DP;

public class MinimumFallingPathSum2 {
    public static void main(String[] args) {
        int matrix [][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Min Falling Path Sum: " + minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base case: last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        // Bottom-up DP
        for (int i = n - 2; i >= 0; i--) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find min & second min in next row
            for (int j = 0; j < n; j++) {
                if (dp[i + 1][j] < min1) {
                    min2 = min1;
                    min1 = dp[i + 1][j];
                    minIndex = j;
                } else if (dp[i + 1][j] < min2) {
                    min2 = dp[i + 1][j];
                }
            }

            // Fill current row
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] +
                        (j == minIndex ? min2 : min1);
            }
        }

        // Answer is min in first row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }

    private static int spaceOptimize(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];

        // Base case: last row
        for (int j = 0; j < n; j++) {
            dp[j] = matrix[n - 1][j];
        }

        // Bottom-up DP
        for (int i = n - 2; i >= 0; i--) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find min & second min in next row
            for (int j = 0; j < n; j++) {
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    minIndex = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }

            // Fill current row
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] +
                        (j == minIndex ? min2 : min1);
            }
        }

        // Answer is min in first row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[j]);
        }

        return ans;
    }
}
