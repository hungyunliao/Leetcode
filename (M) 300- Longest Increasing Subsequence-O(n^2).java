public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] opt = new int[nums.length];
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(max, opt[j]);
                }
            }
            opt[i] = max + 1;
            ans = Math.max(ans, opt[i]);
        }
        
        return ans;
    }
}
