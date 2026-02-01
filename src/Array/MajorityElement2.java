package Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int nums[] = {3,2,3};
        System.out.println("Majority Element: " + majorityElement(nums));
    }
    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count1=0;
        int count2=0;
        int element1=Integer.MIN_VALUE;
        int element2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && element2!=nums[i]){
                count1=1;
                element1=nums[i];
            }
            else if(count2==0 && element1!=nums[i]){
                count2=1;
                element2=nums[i];
            }
            else if(nums[i]==element1){
                count1++;
            }
            else if(nums[i]==element2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int cnt1 =0;
        int cnt2 =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element1){
                cnt1++;
            }
            if(nums[i]==element2){
                cnt2++;
            }
        }
        int n = nums.length;
        int mini = (int)(n / 3) + 1;
        if(cnt1>=mini){
            res.add(element1);
        }
        if(cnt2>=mini){
            res.add(element2);
        }
        return res;
    }
}

// Used same Moore Voting Algorithm which is used in MajorityElement
