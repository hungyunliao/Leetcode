public class Solution {
    int count = 0;
    
    public int uniquePaths(int m, int n) {
        maze(m, n);
        return count;
    }
    
    private void maze(int m, int n) {
        if(m == 1 || n == 1) { 
            count++;
            return; 
        }
        if(m < 1 || n < 1) { return; }
        maze(m - 1, n);
        maze(m, n - 1);
    }
}
