public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1, midR = -1, midC = -1;
        
        if(matrix.length == 0) { return false; }
        
        if(target > matrix[matrix.length - 1][matrix[0].length - 1] || target < matrix[0][0]) { return false; }
        
        while(left <= right) {
            midR = (left + right) / 2;
            if(matrix[midR][0] > target) {
                right = midR - 1;
                midR--;
            } else if(matrix[midR][0] < target) {
                left = midR + 1;
            } else {
                break;
            }
        }
        
        left = 0;
        right = matrix[0].length - 1;
        
        while(left <= right) {
            midC = (left + right) / 2;
            if(matrix[midR][midC] > target) {
                right = midC - 1;
            } else if(matrix[midR][midC] < target) {
                left = midC + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
