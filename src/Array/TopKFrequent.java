package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println("Top K Frequent: "+ Arrays.toString(topKFrequent(nums, k)));
    }
    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        // sort by frquency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->map.get(b)-map.get(a));

        pq.addAll(map.keySet());

        int[] res = new int[k];

        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }

        return res;
    }
}

// T.C - O(n log n) ->  building map → O(n) heap insertion → O(n log n)
// S.C - o(n)
