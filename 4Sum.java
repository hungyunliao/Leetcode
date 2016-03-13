public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        
        if(nums.length <= 3) { return ansList; }
        
        Arrays.sort(nums);
        
        int index1 = 0, index2 = index1 + 1, index3 = index2 + 1, index4 = index3 + 1, len = nums.length;
        
        while(true) {
            if(nums[index4 - 1] == target - (nums[index1] + nums[index2] + nums[index3])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[index1]);
                list.add(nums[index2]);
                list.add(nums[index3]);
                list.add(nums[index4 - 1]);
                if(!ansList.contains(list)) {
                    ansList.add(list);
                }
            } 
            if(index4 == len && index3 < len) {
                index3++;
                index4 = index3 + 1;
            }
            if(index4 == len && index3 == index4 - 1) {
                index2++;
                index3 = index2 + 1;
                index4 = index3 + 1;
            }
            if(index4 == len && index3 == index4 - 1 && index2 == index3 - 1) {
                index1++;
                index2 = index1 + 1;
                index3 = index2 + 1;
                index4 = index3 + 1;
            }
            if(index4 == len && index3 == index4 - 1 && index2 == index3 - 1 && index1 == index2 -1) {
                break;
            }
            index4++;
        }
        return ansList;
    }
}
