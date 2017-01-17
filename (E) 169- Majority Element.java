public class Solution {
    public int majorityElement(int[] nums) {
        // 1. sort and pick the middle element. O(nlogn)
        // 2. using hashmap and record the counts of each element, once found the count >= n/2, return that element. O(n)
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
            if(mp.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1; // something wrong
    }
}
