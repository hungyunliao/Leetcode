public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int leng = A.length;
        if(leng < 3) {
            return 0;
        }
        int[][] dp = new int[leng][leng];
        
        for(int j = 2; j < leng; j++) {
            for(int i = j - 2; i >= 0; i--) {
                
                if(isArithmetics(Arrays.copyOfRange(A, i, j + 1))) {
                    dp[i][j] += dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }
        
        return dp[0][leng - 1];
    }
    
    private boolean isArithmetics(int[] sub) {
        int diff = sub[1] - sub[0];
        for(int i = 1; i < sub.length - 1; i++) {
            if(sub[i + 1] - sub[i] != diff) {
                return false;
            }
        }
        return true;
    }
}
