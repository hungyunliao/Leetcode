public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        
        /*
            j = [1,2,5]
            i = amount
            
            state: T(i, j)
            recur formula:
            T(i, j) = min( T(i - 1) + 1), T(i - 2) + 1, T(i - 5) + 1 )
        
        */
        
        for(int i = 1; i <= amount; i++) {
            for(int j:coins) {
                int state = i - j;  // fetch previous state
                if(state == 0) {
                    dp[i] = 1;
                    break;
                } else if(state < 0) {
                    continue;
                } else {
                    if(dp[state] == 0) { // if the answer for previous state is 0, means that there is no way for this state to be exist.
                        continue;
                    }
                    int sum = dp[state] + 1;
                    if (dp[i] == 0) {
                        dp[i] = sum;
                    } else {
                        dp[i] = Math.min(sum, dp[i]);
                    }
                }
            }
        }
        
        
        return (dp[amount] == 0)? -1 : dp[amount];
    }
}
