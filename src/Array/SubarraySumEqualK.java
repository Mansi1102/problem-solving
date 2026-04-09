package Array;
import java.util.HashMap;

public class SubarraySumEqualK {
    public static void main(String[] args){
        int[] nums = {1,1,1};
        int k = 2;

        System.out.println("Subarray sum: "+ subarraySum(nums,k));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int result =0;
        int prefixSum =0;
        for(int num:nums){
            prefixSum+=num;
            if(map.containsKey(prefixSum-k)){
                result+=map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return result;
    }
}

/*
Approach 2 — Prefix Sum + HashMap (Optimal)

This is the expected interview solution.

Key Idea

If currentSum - previousSum = k
then, previousSum = currentSum - k

So we check if (currentSum − k) already exists.
 */
