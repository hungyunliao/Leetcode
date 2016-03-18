public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int total = 1, zeroCount = 0, zeroIndex = 0;
        int[] ans = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
                if(zeroCount == 2) { return ans; }
            }
            else total *= nums[i];
        }
        
        if(zeroCount == 1) { 
            ans[zeroIndex] = total;
            return ans;
        }
        
        for(int i = 0; i < nums.length; i++) {
            ans[i] = total / nums[i];
        }
        
        return ans;
    }
}
