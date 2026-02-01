package Graph;

import java.util.Arrays;

public class FloodFillAlgorithm {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image; // No need to fill if the color is the same
        int startColor = image[sr][sc];
        int [][] newImage = image;
        int delRow[] = {-1, 0, 1, 0}; // Directions for row movement: up, right, down, left
        int delCol[] = {0, 1, 0, -1}; // Directions for column movement: up, right, down, left
        fill(image, sr, sc, startColor, newColor, delRow, delCol, newImage);
        return newImage;
    }

    public static void fill(int[][] image, int sr, int sc, int startColor, int newColor, int delRow[], int delCol[], int[][] newImage) {
        // Base case: if the current cell is out of bounds or not the starting color
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != startColor) {
            return;
        }
        // Change the color of the current cell
        newImage[sr][sc] = newColor;

        // Explore all four directions
        for (int i = 0; i < 4; i++) {
            int newRow = sr + delRow[i];
            int newCol = sc + delCol[i];

            if(newRow>=0 && newRow<image.length && newCol>=0 && newCol<image[0].length && image[newRow][newCol] == startColor && newImage[newRow][newCol] != newColor) {
                // Recursive call for the next cell in the current direction
                fill(image, newRow, newCol, startColor, newColor, delRow, delCol, newImage);
            }
        }
    }
    public static void main(String[] args){
        int [][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        System.out.println("The modified image after performing the flood fill algorithm is: " + Arrays.deepToString(floodFill(image, sr, sc, newColor)));
    }
}

// Output: The modified image after performing the flood fill algorithm is: [[2, 2, 2], [2, 2, 0], [1, 0, 1]]
// Time Complexity: O(N), where N is the number of pixels in the image. Each pixel is visited at most once.
// Space Complexity: O(N), where N is the number of pixels in the image. The recursion stack can go as deep as the number of pixels in the worst case.
