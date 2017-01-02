public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] appeared = new int[nums.length];
        List<List<Integer>> retVal = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(retVal, temp, nums.length, nums, appeared);
        return retVal;
    }
    
    private void helper(List<List<Integer>> retVal, List<Integer> temp, int size, int[] nums, int[] appeared) {
        if(temp.size() == size - 1) {
            List<Integer> ans = new ArrayList<>(temp);
            for(int i = 0; i < size; i++) {
                if(appeared[i] != 1) {
                    ans.add(nums[i]);
                    retVal.add(ans);
                    return;
                }
            }
        } else {
            for(int i = 0; i < size; i++) {
                if(appeared[i] == 1) {
                    continue;
                }
                appeared[i] = 1;
                temp.add(nums[i]);
                helper(retVal, temp, size, nums, appeared);
                appeared[i] = 0;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
