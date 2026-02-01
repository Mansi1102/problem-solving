package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutations {

    public static void main(String[] args) {
        int candidates[] = {2,3,6,7};
        System.out.println("All Permutations : " + permute(candidates));
    }

    private  static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findPermutation(0, nums, res, new ArrayList<>());
        return res;
    }

    static void findPermutation(int index, int[] nums, List<List<Integer>> res, List<Integer> ds) {
        if (index == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            ds.add(nums[index]);

            findPermutation(index + 1, nums, res, ds);

            ds.remove(ds.size() - 1); // backtrack
            swap(i, index, nums);    // backtrack
        }
    }

    static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
T.C - o(n!*n)
 */
