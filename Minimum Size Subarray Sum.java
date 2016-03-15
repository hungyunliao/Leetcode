public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        int indexL = 0, indexR = 0, min = nums.length + 1, sum = 0;
        
        while(true) {
            if(sum >= s) {
                if(indexR - indexL < min) { min = indexR - indexL; }
                sum -= nums[indexL++];
            } else {
                if(indexR != nums.length) { sum += nums[indexR++]; }
                else break;
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
