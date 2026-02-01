package Array;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        nextPermutation(nums);
        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }

        public static void nextPermutation(int[] nums) {
            int index = -1;
            int n= nums.length;
            for(int i=n-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    index=i;
                    break;
                }
            }
            if(index == -1){
                reverse(nums,0,n-1);
            }
            else{
                for(int i=n-1;i>=index;i--){
                    if(nums[i]>nums[index]){
                        swap(nums,i,index);
                        break;
                    }
                }
                reverse(nums,index+1,n-1);
            }
        }
        private static void swap(int nums[], int i, int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        private static void reverse(int nums[], int start,int end){
            while(start<end){
                swap(nums,start,end);
                start++;
                end--;
            }
        }
    }

/*
Complexity Analysis
Time Complexity: O(N), we find the breaking point and reverse the subarray in linear time.
Space Complexity: O(1), constant additional space is used.
 */

/*
1️⃣ What is the intuition behind the algorithm?

Expected explanation (must sound structured):

We want the next lexicographically greater permutation.
To achieve this with minimal change:

Find the first index from the right where the order breaks

Replace it with the smallest number greater than it on the right

Sort (reverse) the remaining suffix to get the smallest arrangement

💡 Keywords interviewer listens for:

lexicographical order

rightmost increasing pair

minimal greater permutation

2️⃣ Why do we search from right to left?
for (int i = n-2; i >= 0; i--)


Correct reasoning:

The rightmost part is already the largest possible arrangement

We want to change the permutation as little as possible

So we fix the first position where we can increase the value

👉 Interviewer trap:

“Why not left to right?”

Answer:

Because left-to-right would cause a larger jump and skip permutations.

3️⃣ What does index represent?
if (nums[i] < nums[i+1]) {
    index = i;
}


Expected answer:

index is the pivot

It marks the first place from the right where we can increase the permutation

💬 One-liner:

“It is the rightmost position where nums[i] < nums[i+1].”

4️⃣ Why reverse the whole array when index == -1?
if (index == -1) {
    reverse(nums, 0, n-1);
}


Expected explanation:

This means the array is already in descending order

No higher permutation exists

So we return the smallest permutation (ascending order)

✔ Example:

[3,2,1] → [1,2,3]

5️⃣ Why do we search from the end to swap?
for (int i = n-1; i >= index; i--) {
    if (nums[i] > nums[index]) {
        swap(nums, i, index);
        break;
    }
}


Expected reasoning:

We want the smallest number greater than nums[index]

Searching from the end guarantees the closest larger value

This ensures the permutation is the next, not just a larger one

🔥 Interview keyword:

“smallest greater element in suffix”

6️⃣ Why do we reverse index + 1 to n - 1?
reverse(nums, index+1, n-1);


Correct explanation:

After swapping, the suffix is still in descending order

Reversing it makes it the smallest possible arrangement

This guarantees the next permutation is minimal

👉 If asked:

“Why reverse and not sort?”

Answer:

Because the suffix is already in descending order → reverse is O(n)

7️⃣ What is the time and space complexity?

Answer:

Time: O(n)

Space: O(1) (in-place)

💬 Always say in-place explicitly.

8️⃣ Can you dry run this input?
Example:
nums = [1, 2, 3]


Steps:

index = 1 (2 < 3)

swap(2,3) → [1,3,2]

reverse suffix → [1,3,2]

Example:
nums = [3, 2, 1]


index = -1

reverse whole array → [1,2,3]

9️⃣ Edge cases interviewer may ask

You should mention:

✔ Single element array
✔ Already largest permutation
✔ Duplicate numbers (e.g. [1,1,5])
✔ All elements same

👉 Important:

This algorithm works correctly even with duplicates

🔟 Why does this algorithm always work?

Strong interview answer:

“Because lexicographical order depends on the first differing position, and we modify the rightmost such position with the smallest possible increase.”

This shows deep understanding.

1️⃣1️⃣ What if interviewer asks for previous permutation?

You should say:

Reverse logic:

Find nums[i] > nums[i+1]

Swap with largest smaller element

Reverse suffix
 */