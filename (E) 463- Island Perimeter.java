public class Solution {
    public int islandPerimeter(int[][] grid) {
        // see 1's neighbors, if it's 0, then ans++;
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    ans += findNeighbors(i, j, grid);
                }
            }
        }
        return ans;
    }
    
    private int findNeighbors(int row, int col, int[][] grid) {
        // grid[row][col] == 1
        int ret = 0;
        if( row - 1 < 0 || grid[row - 1][col] == 0) {
            ret++;
        }
        if( col - 1 < 0 || grid[row][col - 1] == 0) {
            ret++;
        }
        if( row + 1 >= grid.length || grid[row + 1][col] == 0) {
            ret++;
        }
        if( col + 1 >= grid[0].length || grid[row][col + 1] == 0) {
            ret++;
        }
        return ret;
    }
}
