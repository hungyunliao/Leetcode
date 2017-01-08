public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // in place. Minus the number in nums[nums]
        // for loop: if the nums[index] is positive, means that index never appears.
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) nums[index] *= -1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
