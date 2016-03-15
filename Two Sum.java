public class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* 
            for a sorted array, two indices, first begins from left, second begins from right, if left + right > target, than right--, otherwise left++ -> O(n)
        */
        
        int[] newNum = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) { newNum[i] = nums[i]; }
        
        Arrays.sort(nums);
        
        int indexL = 0, indexR = nums.length - 1;
        int[] ans = {-1, -1};
        
        while(indexR != indexL) {
            if(nums[indexL] + nums[indexR] > target) { indexR--; } 
            else if(nums[indexL] + nums[indexR] < target) { indexL++; } 
            else { break; }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(ans[0] == -1 && newNum[i] == nums[indexL]) {
                ans[0] = i;
                continue;
            }
            if(ans[1] == -1 && newNum[i] == nums[indexR]) { ans[1] = i; }
        }
        
        return ans;
    }
}
