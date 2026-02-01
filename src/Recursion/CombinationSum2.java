package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int candidates[] = {2,3,6,7};
        int target  = 7;
        System.out.println("Combintation Sum2: " + combinationSum2(candidates, target));
    }
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0,candidates, target, res, new ArrayList<>());
        return res;
    }
    private static void findCombination(int index, int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){
        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            ds.add(candidates[i]);
            findCombination(i+1,candidates, target-candidates[i], res, ds);
            ds.remove(ds.size()-1);
        }
    }
}

/*
Overall Time Complexity
0(nlogn + 2^n*n)
n log n → sorting

2^n * n → backtracking + copying combinations

In practice, pruning (if(candidates[i] > target) break) and duplicate skipping significantly reduce the actual runtime.
 */
