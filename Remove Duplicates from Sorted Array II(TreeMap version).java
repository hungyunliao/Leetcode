public class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        int count = 0, j = 0;
        
        if(nums.length == 0) { return 0; }
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(map.get(nums[i]) == 2) {
                   count++;
                }
                else map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        
        while(iter.hasNext()) {
            Map.Entry<Integer, Integer> curr = iter.next();
            if(curr.getValue() == 2) {
                nums[j++] = curr.getKey();
                nums[j++] = curr.getKey();
            } else {
                nums[j++] = curr.getKey();
            }
        }
        
        return nums.length - count;
    }
}
