public class Solution {
    public int minMoves(int[] nums) {
        // scan the array, and find the max value
        // scan the array, if the value == max value (first time), skip; otherwise, plus 1, ans++. Record the max value at the same time.
        // repeat until all values are the same.
        
        // corner case block:
        // if(nums.length == 1) {
        //     return 0;
        // }
        
        int oldMax = nums[0], newMax = nums[0];
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++) {
            newMax = Math.max(newMax, nums[i]);
        }
        
        while(!areAllSame(nums)) {
            oldMax = newMax;
            boolean canSkip = false;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != oldMax || canSkip) {
                    nums[i]++;
                } else {
                    canSkip = true;
                }
                newMax = Math.max(newMax, nums[i]);
            }
            ans++;
        }
        return ans;
    }
    
    private boolean areAllSame(int[] nums) {
        int base = nums[0];
        for(int num : nums) {
            if(num != base) {
                return false;
            }
        }
        return true;
    }
}
