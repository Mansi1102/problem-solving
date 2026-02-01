package BinarySearch;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        System.out.println("Minimum in rotated sorted array: " + findMin(nums));
    }

    static int findMin(int[] nums) {
        int n = nums.length;
        int low=0;
        int high=n-1;
        int min=Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                min= Math.min(nums[low],min);
                low = mid+1;
            }
            else{
                high=mid-1;
                min=Math.min(nums[mid],min);
            }
        }
        return min;
    }
}

/*
If duplicate exist:
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                min= Math.min(nums[low],min);
                low=low+1;
                high=high-1;
                continue;
            }
 */
