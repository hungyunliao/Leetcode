public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        
        if(nums.length <= 3) { return ansList; }
        
        Arrays.sort(nums);
        
        int index1 = 0, index2 = index1 + 1, index3 = index2 + 1, index3pValue = 0, len = nums.length, index4 = len - 1;
        int fitIndex = -1;
        
        while(true) {
            if(fitIndex != -1) { 
                fitIndex = bSearch(nums, fitIndex, index4, target - nums[index1] - nums[index2] - nums[index3]); 
            } else fitIndex = bSearch(nums, index3 + 1, index4, target - nums[index1] - nums[index2] - nums[index3]);
            
            if(fitIndex != -1) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[index1]);
                list.add(nums[index2]);
                list.add(nums[index3]);
                list.add(nums[fitIndex]);
                if(!ansList.contains(list)) {
                    ansList.add(list);
                }
            }
            
            if(index3 <= len - 2) {
                index3++;
                index4 = len - 1;
            }
            if(index3 > len - 2) {
                fitIndex = -1;
                index3 = index2 + 1;
                index4 = len - 1;
            }
            if(index2 > len - 3) {
                fitIndex = -1;
                index2 = index1 + 1;
                index3 = index2 + 1;
                index4 = len - 1;
            }
            if(index1 > len - 4) {
                break;
            }
        }
        return ansList;
    }
    
    private int bSearch(int[] arr, int left, int right, int target) {
        if(arr[right] == target) {
            return right;
        }
        
        int temp = (left + right) / 2;
        
        if(left == temp) {
            if(arr[temp] == target) { return temp; }
            else return -1;
        }
        
        if(arr[temp] == target) {
            return temp;
        }
        else if(arr[temp] > target) {
            return bSearch(arr, left, temp, target);
        }
        else {
            return bSearch(arr, temp, right, target);
        }
        
    }
}
