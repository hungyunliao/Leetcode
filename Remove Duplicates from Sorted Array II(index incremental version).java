public class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 0) { return 0; }
        
        int count = 1, dup = nums[0], dupAllow = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == dup) {
                if(dupAllow == 1) {
                    dupAllow--;
                    nums[count] = nums[i];
                    count++;
                }
            } else {
                dup = nums[i];
                nums[count] = dup;
                count++;
                dupAllow = 1;
            }
        }
        return count;
    }    
}
