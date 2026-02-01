package Array;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {3,2,3};
        System.out.println("Majority Element: " + majorityElement(nums));
    }
    private static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}

/*
Approach 3: Moore Voting Algorithm

Intuition:
The intuition behind the Moore's Voting Algorithm is based on the fact that if there is a majority element in an array, it will always remain in the lead, even after encountering other elements.

Explanation:
Algorithm:

Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.
Iterate through the array nums:
a. If count is 0, assign the current element as the new candidate and increment count by 1.
b. If the current element is the same as the candidate, increment count by 1.
c. If the current element is different from the candidate, decrement count by 1.
After the iteration, the candidate variable will hold the majority element.

Dry run:-

[2,2,1,1,1,2,2]

Count=0
Candidate =0
 for(int i: nums)
Step1:
i=2
count =0
Candidate =2
Count =1;

Step2:
Candidate =2
Count =2;

Step3:
Candidate =2
Count =1;

Step4:
Candidate =1
Count =2;

Step5:
Candidate =1
Count =3;

Step6:
Candidate =1
Count =2;

Step7:
Candidate =2
Count =3;

Complexity:

TC - 0(n)
SC - 0(1)
 */
