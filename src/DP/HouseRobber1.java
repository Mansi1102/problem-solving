package DP;

public class HouseRobber1 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        System.out.println("Maximum amount of money can rob tonight without alerting the police: " + rob1(nums));
    }

    /*Approach1
    Using DP Tabulation
     */
    private static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    /*
    Approach 2 Space optimization
     */

    private static int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = nums[0];                     // dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]);  // dp[i-1]

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

/*
T.C - 0(n)
S.C - 0(1)
 */

/*
HouseRob2 - first and last are adjacent to each other
 */

    private static int rob3(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int case1 = helper(nums, 0, n - 2);
        int case2 = helper(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private static int helper(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}