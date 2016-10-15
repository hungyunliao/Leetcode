public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] memo = new int[target + 1];
        memo[0] = 1; // boarder case
        
        /*
            numArr = [1, 2, 3]
        
                  V (target - num[2])  +
                      V (target - num[1])  +
                          V (target - num[0])  = memo[target]
            | 0 |   |   |   |   | 
              0   1   2   3   4   -> target
        */
        
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) { // recursive function
                int prevCell = i - nums[j];
                if(prevCell < 0) {
                    continue;
                } else if(prevCell == 0) {
                    memo[i] += 1;
                }
                else {
                   if(memo[prevCell] != 0) {
                        memo[i] += memo[prevCell];
                    } 
                }
                
            }
        }
        return memo[target];
        // 
    }
}
