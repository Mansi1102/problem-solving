package Array;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
        int k =2;
        System.out.println("Find kth largest: " + findKthLargest(nums,k));
    }
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: nums){
            minHeap.add(i);
            while(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
}
