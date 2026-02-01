package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {

    public static void main(String[] args) {
        int candidates[] = {2,3,6,7};
        System.out.println("Subset Sum2: " + subsetsWithDup(candidates));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        findCombination(0,nums,res,new ArrayList<>());
        return res;
    }

    private static void findCombination(int index, int[] nums, List<List<Integer>> res, List<Integer> ds){
        res.add(new ArrayList<>(ds));

        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findCombination(i+1,nums,res,ds);
            ds.remove(ds.size()-1);
        }
    }
}
