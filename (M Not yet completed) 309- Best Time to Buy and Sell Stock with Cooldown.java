public class Solution {
    public int maxProfit(int[] prices) {
        int leng = prices.length;
        if(leng == 0 || leng == 1) return 0;
        else if(leng == 2) return (prices[1] - prices[0] > 0)?   prices[1] - prices[0]:0;
        int[] dp = new int[leng];
        dp[0] = 0;
        
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + (prices[i] - prices[i - 1]);
            if(dp[i] < 0) {
                dp[i] = 0;
            }
            
        }
        if(leng <= 3) {
            int max = 0;
            max = Math.max(dp[0], Math.max(dp[1], dp[2]));
        }
        
        int[] opt = new int[dp.length];
        opt[0] = dp[0];
        opt[1] = dp[1];
        opt[2] = Math.max(dp[2], dp[1]);
        //opt[3] = Math.max(dp[3], dp[2]);
        for(int ele:dp) {
            System.out.print(ele);
        }
        for(int i = 3; i < opt.length; i++) {
            // int diff = ((prices[i] - prices[i - 1]) < 0)? 0:prices[i] - prices[i - 1];
            // int diff2 = ((prices[i] - prices[i - 2]) < 0)? 0:prices[i] - prices[i - 2];
            // int diff3 = ((prices[i] - prices[i - 3]) < 0)? 0:prices[i] - prices[i - 3];
            // int max = Math.max(diff, Math.max(diff2, diff3));
        
            //opt[i] = Math.max(opt[i - 3] + dp[i] - dp[i - 1], Math.max(dp[i], opt[i - 1]));
            for(int j = 0; j <= i - 3; j++) {
                for(int k = j + 2; k <= i; k++) {
                    
                }
                opt[i] = Math.max(opt[i], opt[j] + prices[i] - prices[i - 1]);
            }
            
            opt[i] = Math.max(opt[i], Math.max(opt[i - 1], Math.max(opt[i - 2], dp[i])));
            
            //opt[i] = opt[i - 3] + dp[i] - dp[i-1];
            // int prev = dp[i - 1] - dp[i - 2];
            // if(prev < 0) {
            //     prev = 0;
            // }
            // int after = dp[i] - dp[i - 1];
            // if(after < 0) {
            //     after = 0;
            // }
            // opt[i] = Math.max(opt[i - 4] + prev, opt[i - 3] + after);
        }
        //opt[opt.length - 1] = Math.max(opt[opt.length - 1], dp[dp.length - 1]);
        return opt[opt.length - 1];
    }
}
