public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // if it's 1, count++; otherwise, count = 0
        // whenever count = 0, max = Math.max(max, count)
        // O(n) time complexity. O(1) space.
        
        int count = 0, max = 0;
        for(int num : nums) {
            if(num == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
