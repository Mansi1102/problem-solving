package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int candidates[] = {2,3,6,7};
        int target  = 7;
        System.out.println("Combintation Sum: " + combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombination(0,candidates,target,res, new ArrayList<>());
        return res;
    }

    private static void findCombination(int index,int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){
        if(index==candidates.length){
            if(target==0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index]<=target){
            ds.add(candidates[index]);
            // pick
            findCombination(index,candidates,target-candidates[index],res,ds);
            ds.remove(ds.size()-1);
        }
        // Not pick
        findCombination(index+1,candidates,target,res,ds);
    }
}

// T.c = o(2^t*k)
