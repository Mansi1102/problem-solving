package Array;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int matrix [][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println("Matrix:" + searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col]==target){
                return true;
            }
            else if(target>matrix[row][col]){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}

/*
✅ Key Idea

Instead of searching row by row, we can treat the 2D matrix as a 1D sorted array and apply binary search — O(log(n * m)) time complexity.

💡 Intuition

If you “flatten” the matrix above, it looks like this:

Index → 0  1  2  3  4   5   6   7   8  9  10  11
Value → 1  3  5  7  10  11  16  20  23 30  34  50


But instead of actually flattening it (which wastes memory),
we compute the row and column from the 1D index using division and modulus:

row = mid / m

col = mid % m

Time & Space Complexity

Time: O(log(n * m))
Space: O(1)
 */
