package DP;

public class CherryPickupII {
    public static void main(String[] args) {
        int grid [][] = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println("Max.cherry Pickup: " + cherryPickup(grid));
    }
    private static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // 3D DP table
        int[][][] dp = new int[n][m][m];

        // Base case: last row
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        // Fill DP table bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = (int)(-1e9);
                    int curr = (j1 == j2) ? grid[i][j1]
                            : grid[i][j1] + grid[i][j2];
                    // Try all 9 moves
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;
                            if (newJ1 >= 0 && newJ1 < m &&
                                    newJ2 >= 0 && newJ2 < m) {
                                maxi = Math.max(maxi, curr +
                                        dp[i+1][newJ1][newJ2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
}

/*
T.C - O(n × m × m × 9) → O(n × m²)
S.C - O(n × m²)
 */
