package BinarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int nums[] = {1,1,2,3,3,4,4,8,8};
        System.out.println("Single element in sorted array: " + singleNonDuplicate(nums));
    }
    static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            // We are on left
            if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])){
                low = mid+1;
            }
            // We are on right
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}

/*

-----Intuition----
1. Array pattern before and after the single element

When every element appears exactly twice and the array is sorted, you can visualize like this:

Example
nums = [1,1,2,2,3,4,4,5,5]
                   ↑
                single element = 3

Index	Value
0	1
1	1
2	2
3	2
4	3 ← single
5	4
6	4
7	5
8	5
Now observe:

Before the single element → pairs start at even indices:
(0,1), (2,3)

After the single element → pairs start at odd indices:
(5,6), (7,8)

That means the pattern flips after the single element.

🔹 2. Binary search intuition

We pick mid and check if we are on the left side (normal pattern) or right side (flipped pattern).

If we can detect which side we are on, we can move our binary search toward the single element.

🔹 3. How even/odd index helps

Let’s take the current mid index and see how it behaves.

🧮 Case 1: mid is even

If we are on the left (normal) side:

every even index mid should match mid+1

example: (0,1), (2,3)

If that’s true → pattern is still normal → single element is to the right → low = mid + 1

If it’s not true → pattern is broken → single element is to the left → high = mid - 1

🧮 Case 2: mid is odd

If we are on the left (normal) side:

every odd index mid should match mid-1

example: (1,0), (3,2)

If that’s true → pattern is normal → single element is to the right → low = mid + 1

If not → single element is to the left → high = mid - 1
 */