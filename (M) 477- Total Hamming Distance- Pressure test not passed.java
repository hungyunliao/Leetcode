public class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                ans += helper(nums[i], nums[j]);
            }
        }
        return ans;
    }
    
    private int helper(int a, int b) {
        if(a == b) {
            return 0;
        }
        int ans = 0, p1 = 1, p2 = 1;
        int max = (1 << 31);
        int diff = (a ^ b);
        while(p1 != max) {
            if((diff & p1) == p1) {
                ans++;
            }
            p1 <<= 1;
        }
        return ans;
    }
}
