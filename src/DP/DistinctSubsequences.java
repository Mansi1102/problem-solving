package DP;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s ="rabbbit";
        String t ="rabbit";
        System.out.println("Distinct Subsequences: " + numDistinct(s,t));
    }
    private static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // empty t
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0; // empty s
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // pick + not pick
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // not pick
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
    private static int optimizedSpace(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] dp = new int[m + 1];

        // Base cases
        dp[0]=1;

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // pick + not pick
                    dp[j] = dp[j - 1] + dp[j];
                } else {
                    // not pick
                    dp[j] = dp[j];
                }
            }
        }

        return dp[m];
    }
}
