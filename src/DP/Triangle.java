package DP;

import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println("Minimum total: " + minimumTotal(triangle));
    }
    private static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Fill last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Fill remaining rows bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] =
                        triangle.get(i).get(j) +
                                Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}

/*
T.C - 0(n*m)
S.C - 0(n*m)
 */

// Approach 2- Use 1d array to optimize space

/*
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Fill last row
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Fill remaining rows bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] =
                    triangle.get(i).get(j) +
                    Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
 */

// S.C - 0(n)