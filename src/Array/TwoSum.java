package Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        System.out.println("Two Sum: " + Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int element = target-nums[i];
            if(map.containsKey(element)){
                return new int[] {map.get(element),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

// T.C = 0(n)
