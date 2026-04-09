package Array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println("Product Of Array Except Self: " + Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;

        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;

        for(int i = nums.length-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            res[i] = left[i] * right[i];
        }

        return res;
    }
}

// T.C - o(n)
// S.C - o(n)

/*
Optimal Approach
public int[] productExceptSelf(int[] nums) {

    int n = nums.length;
    int[] res = new int[n];

    res[0] = 1;

    for(int i = 1; i < n; i++){
        res[i] = res[i-1] * nums[i-1];
    }

    int right = 1;

    for(int i = n-1; i >= 0; i--){
        res[i] = res[i] * right;
        right = right * nums[i];
    }

    return res;
}
 */
