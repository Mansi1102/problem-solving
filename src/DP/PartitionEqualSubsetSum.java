package DP;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println("Partition possible: " + canPartition(nums));
    }
    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        return subsetSum(nums, nums.length, target);
    }

    static boolean subsetSum(int[] nums, int n, int target) {
        boolean[][] dp = new boolean[n][target + 1];

        // sum = 0 is always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // first element
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // fill DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                // not pick
                dp[i][j] = dp[i - 1][j];

                // pick
                if (j >= nums[i]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n - 1][target];
    }

    static boolean optimizeSpaceSubsetSum(int[] nums, int n, int k) {
        boolean[] dp = new boolean[k + 1];

        // Base case
        dp[0] = true;

        // First element
        if (nums[0] <= k) {
            dp[nums[0]] = true;
        }

        // Process remaining elements
        for (int i = 1; i < n; i++) {
            for (int target = k; target >= nums[i]; target--) {
                dp[target] = dp[target] || dp[target - nums[i]];
            }
        }

        return dp[k];
    }
}
