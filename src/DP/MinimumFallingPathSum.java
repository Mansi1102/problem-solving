package DP;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int matrix [][] = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Min Falling Path Sum: " + minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        // Initialize last row
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = matrix[m - 1][j];
        }

        // Bottom-up DP
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = dp[i + 1][j];
                int leftDiag = j > 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = j < n - 1 ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] +
                        Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        // Minimum from first row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }

    private static int spaceOptimize(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = matrix[m - 1].clone();

        for (int i = m - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int down = dp[j];
                int left = j > 0 ? dp[j - 1] : Integer.MAX_VALUE;
                int right = j < n - 1 ? dp[j + 1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] +
                        Math.min(down, Math.min(left, right));
            }
            dp = curr;
        }

        int ans = Integer.MAX_VALUE;
        for (int v : dp) ans = Math.min(ans, v);
        return ans;
    }
}
