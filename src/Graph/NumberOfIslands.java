package Graph;

public class NumberOfIslands {
    public static int numIslands(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }

    public static void dfs(int row, int col, int[][] grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        // Mark the cell as visited
        grid[row][col] = 0;

        // Explore all 4 directions
        dfs(row + 1, col, grid); // Down
        dfs(row - 1, col, grid); // Up
        dfs(row, col + 1, grid); // Right
        dfs(row, col - 1, grid); // Left
    }

    public static void main(String[] args){
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };
        System.out.println("Number of Islands: " + numIslands(grid));
    }
}

//Time Complexity: O(n × m)
//Space Complexity: O(n × m) (recursion stack)

