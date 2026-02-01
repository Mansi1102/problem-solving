package BinarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        int target = 8;
        System.out.println("Search Range: " + Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstPosition(nums, n, target);
        if (first == -1) return new int[]{-1, -1};
        int second = secondPosition(nums, n, target);
        return new int[]{first, second};
    }

    static int firstPosition(int[] nums, int n, int target) {
        int low = 0, high = n - 1, first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;  // keep searching left
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first;
    }

    static int secondPosition(int[] nums, int n, int target) {
        int low = 0, high = n - 1, second = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                second = mid;
                low = mid + 1;  // keep searching right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return second;
    }
}
