public class Solution {

    public int uniquePaths(int m, int n) {
        if(m == 1) { return 1; }
        else if( m == 0 ) { return 0; }
        
        m = m - 1;
        int[][] matx = new int[m][n];
        
        for(int i = 0; i < n; i++) { matx[m - 1][i] = n - i; }
        
        for(int i = m - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                for(int k = j; k < n; k++) {
                    matx[i][j] += matx[i + 1][k];
                }
            }
        }
        
        return matx[0][0];
    }
}
