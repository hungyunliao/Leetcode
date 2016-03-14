public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        
        if(nums.length <= 3) { return ansList; }
        
        Arrays.sort(nums);
        
        int index1 = 0, index2 = index1 + 1, index3 = index2 + 1, len = nums.length, index4 = len - 1;
        int sum2 = 0;
        
        for(index1 = 0; index1 < len - 3; index1++) {
            for(index2 = index1 + 1; index2 < len - 2; index2++) {
                index3 = index2 + 1;
                index4 = len - 1;
                sum2 = target - nums[index1] - nums[index2];
                while(true) {
                    if(nums[index3] + nums[index4] > sum2) {
                        index4--;
                    } else if(nums[index3] + nums[index4] < sum2) {
                        index3++;
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[index1]);
                        list.add(nums[index2]);
                        list.add(nums[index3]);
                        list.add(nums[index4]);
                        if(!ansList.contains(list)) {
                            ansList.add(list);
                        }
                        index3++;
                        index4--;
                    }
                    if(index3 >= index4) { break; }
                }
            }
        }
        
        return ansList;
    }
}
