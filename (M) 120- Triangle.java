public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        //Algo:
        //opt(i, index) = 0 <= index < row.length min(opt(i - 1, index + 1), opt(i - 1, index - 1))
        //if index - 1
        
        int depth = triangle.size();
        int total = 0;
        for(int i = 1; i <= depth; i++) {
            total += i;
        }
        
        // Initialize dp table and set the boundary condition.
        int[] dp = new int[total];
        dp[0] = triangle.get(0).get(0);
        
        for(int row = 1; row < depth; row++) {
            for(int col = 0; col < triangle.get(row).size(); col++) {
                int index = rowToIndex(row, col);
                int leftIndex = (col - 1 >= 0)? rowToIndex(row - 1, col - 1):rowToIndex(row - 1, col);
                int rightIndex = (col < triangle.get(row - 1).size())? rowToIndex(row - 1, col):rowToIndex(row - 1, col - 1);
                
                dp[index] = triangle.get(row).get(col) + Math.min(dp[leftIndex], dp[rightIndex]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        int indexOfLastRowFirstElement = rowToIndex(depth - 1, 0);
        int indexOfLastRowLastElement = indexOfLastRowFirstElement + triangle.get(depth - 1).size() - 1;
        for(int i = indexOfLastRowFirstElement; i <= indexOfLastRowLastElement; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
    
    // returns the according 1D array index for the (row, col) in the triangle matrix.
    private int rowToIndex(int row, int col) {
        return (1 + row) * row / 2 + col;
    }
}
