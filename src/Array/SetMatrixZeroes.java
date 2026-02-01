package Array;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int matrix [][] = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0=1;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                col0=0;
            }
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(col0==0){
                matrix[i][0]=0;
            }
        }
    }

    private static void setZeroes1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Check first row
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Use first row & column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeroes based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first column if needed
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        // Zero first row if needed
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }

}

// Time complexity = O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
// Space Complexity: O(1) as we are not using any extra space.

/*
1️⃣ Why did you use firstRowZero and firstColZero?

Expected reasoning:

First row and first column are reused as markers.

If they originally contain 0, we’d lose that information when marking.

So we store their original state separately.

💡 Key line to say:

“Since the first row and column are used as markers, we need extra flags to remember whether they should finally be zeroed.”

2️⃣ Why do we start loops from i = 1 and j = 1?

Expected answer:

Index 0 is reserved for marker storage.

Starting from 1 avoids overwriting marker information.

👉 If asked what happens if you start from 0:

You’ll corrupt marker data → wrong output.

3️⃣ What is the time and space complexity?

Answer:

Time Complexity: O(n × m)

Space Complexity: O(1) (in-place, only two booleans used)

💬 Interviewers love this exact phrasing.

4️⃣ Can you explain this approach in simple steps?

Ideal structured explanation:

Check if first row or first column originally has zero

Use first row and column as markers

Zero out cells based on markers

Finally zero first row/column if required

This shows clarity + confidence.

5️⃣ Why can’t we solve this in one pass?

Expected explanation:

If you set zeroes immediately, you’ll introduce new zeroes

Those new zeroes will incorrectly affect other rows/columns

💡 Keyword interviewer looks for: “data contamination”

6️⃣ What are the edge cases?

You should mention at least these:

✔ Matrix with no zeroes
✔ Matrix with only one row
✔ Matrix with only one column
✔ Matrix where (0,0) is zero
✔ Matrix where entire row or column is zero

👉 Bonus: mention 1x1 matrix

7️⃣ Why not use extra arrays for rows and columns?

Expected response:

That solution works but uses O(n + m) space

This optimized solution reduces space to O(1)

You can even say:

“This is the optimized version of the rowSet/colSet approach.”

8️⃣ What happens if matrix[0][0] is zero?

Correct explanation:

matrix[0][0] is shared by both row and column

That’s why we use two separate flags

It correctly zeroes both first row and first column

🔥 This is a very common trick question.

9️⃣ Can you dry run this with an example?

They might give:

[
 [1, 1, 1],
 [1, 0, 1],
 [1, 1, 1]
]


They’ll watch:

How markers are set

When actual zeroing happens

Whether you confuse marker phase vs update phase

🔟 Can this be further optimized?

Correct answer:

No, because:

Time is already optimal O(n*m)

Space is already optimal O(1)

1️⃣1️⃣ What if input matrix is immutable?

Expected response:

Then in-place modification isn’t allowed

We must use extra space → O(n + m) solution

1️⃣2️⃣ How would you explain this to a junior developer?

Interviewers ask this to check communication skill.

Best simple line:

“We use the first row and column as sticky notes to remember which rows and columns should be zeroed.”
 */