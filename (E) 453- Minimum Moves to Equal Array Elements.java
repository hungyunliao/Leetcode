public class Solution {
    public int minMoves(int[] nums) {
        // adding n - 1 element by 1 means the same as substract 1 of the rest element.
        // calculate the num - min and add them together.
        
        int min = nums[0], ans = 0;
        for(int num : nums) {
            min = Math.min(min, num);
        }
        for(int num : nums) {
            ans += (num - min);
        }
        return ans;
    }
}
