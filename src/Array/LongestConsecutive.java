package Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        int nums[] = {100,4,200,1,3,2};
        System.out.println("Longest Consecutive: " + longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        int n=nums.length;
        int longest = 1;
        if(n==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int itr:set){
            if(!set.contains(itr-1)){
                int count =1;
                int x = itr;
                while(set.contains(x+1)){
                    count=count+1;
                    x=x+1;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}

/*
T.C - o(n)
S.C - o(n)
 */