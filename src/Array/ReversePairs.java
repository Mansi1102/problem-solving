package Array;

import java.util.ArrayList;

public class ReversePairs {
    public static void main(String[] args) {
        int nums[] = {1,3,2,3,1};
        System.out.println("Reverse Pairs: " + reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (left <= mid) temp.add(nums[left++]);
        while (right <= high) temp.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    private static int CountPairs(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int cnt = mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += CountPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }
}

/*
Intuition
The problem asks us to find the number of reverse pairs in an array, where a reverse pair is defined as (i, j) such that i < j and nums[i] > 2 * nums[j].

My first thought is to use a modified merge sort approach. During the merge process, we can count how many elements in the left half are greater than twice the elements in the right half. This leverages the divide-and-conquer nature of merge sort while maintaining the relative order information we need.

Approach
Divide and Conquer with Merge Sort: Use merge sort to recursively divide the array into smaller subarrays.

Count Pairs During Merge: Before merging two sorted halves, count the reverse pairs between them:

For each element in the left half, find how many elements in the right half satisfy the condition nums[i] > 2 * nums[j]
Since both halves are sorted, we can use two pointers to efficiently count pairs
Merge Process: After counting pairs, perform the standard merge operation to maintain the sorted order for subsequent recursive calls.

Combine Results: The total count is the sum of:

Pairs from the left half (recursive call)
Pairs from the right half (recursive call)
Pairs between left and right halves (counted during merge)
Complexity
Time complexity: O(nlogn)

The merge sort has O(nlogn) time complexity
The counting operation in each merge step takes O(n) time
Overall: O(nlogn)
Space complexity: O(n)

O(n) space for the temporary array used in merging
O(logn) space for the recursion stack
Overall: O(n)
 */
