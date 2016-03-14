public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        
        int height = matrix.length, width = matrix[0].length;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) {
                    if(!row.contains(i)) { row.add(i); }
                    if(!col.contains(j)) { col.add(j); }
                }
            }
        }
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(row.contains(i)) { matrix[i][j] = 0; }
                else if(col.contains(j)) { matrix[i][j] = 0; }
            }
        }
    }
}
