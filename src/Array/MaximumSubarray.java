package Array;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
        System.out.println("Maximum Subarray: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}

/*
Complexity Analysis

Time Complexity: O(N), where N = size of the array.
Reason: We are using a single loop running N times.

Space Complexity: O(1) as we are not using any extra space.
 */
