public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        
        /*
          Subproblem:
          T(i): the combination for i stairs.
          
          T(1) = [1]
          T(2) = [1,1], [2]
          T(3) = [1,1,1], [1,2], [2,1]
          
          Formula:
          T(i) = T(i - 1) + T(i - 2)
          
        */
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}
