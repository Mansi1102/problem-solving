package BinarySearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Search in rotated sorted array: " + search(nums, target));
    }

    static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}

/*
To fix code smells:

private boolean isLeftSorted(int[] nums, int low, int mid) {
    return nums[low] <= nums[mid];
}

private boolean targetInLeft(int[] nums, int low, int mid, int target) {
    return nums[low] <= target && target < nums[mid];
}

private boolean targetInRight(int[] nums, int mid, int high, int target) {
    return nums[mid] < target && target <= nums[high];
}

while (low <= high) {
    int mid = (low + high) / 2;
    if (nums[mid] == target) return mid;

    if (isLeftSorted(nums, low, mid)) {
        if (targetInLeft(nums, low, mid, target)) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    } else {
        if (targetInRight(nums, mid, high, target)) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
}

 */

//Time Complexity: O(log n)
//Space Complexity: O(1)

/*
If duplicate exist in an array:

    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return true;

            // Shrinks the window until we can properly determine which side is sorted.
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low=low+1;
                high=high-1;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
 */