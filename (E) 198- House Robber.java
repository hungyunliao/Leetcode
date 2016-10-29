public class Solution {
    public int rob(int[] nums) {
        int leng = nums.length;
        if(leng == 0) 
          return 0;
        
        // dp[i]: the maxmize amount of money that can be rubbed from house i to house n.
        int[] dp = new int[leng + 1];
        dp[leng] = 0;
        dp[leng - 1] = nums[leng - 1];
        
        // For this problem, the cool time is 1
        int coolTime = 1;
        for(int i = leng - 2; i >= 0; i--)
           dp[i] = Math.max(dp[i + 1], dp[i + 1 + coolTime] + nums[i]);
            
        return dp[0];
    }
}
