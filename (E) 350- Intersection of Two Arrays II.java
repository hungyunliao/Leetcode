public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // create two hashmaps. One for nums1, the other one for nums2
        // record the integer and the counts for each integer
        // scan again any of the nums1 or nums2.
        // if the num exists in both map, get the min of the count in map1 and map2. Print it to the ans.
        
        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1) {
            mp1.put(num, mp1.getOrDefault(num, 0) + 1);
        }
        for(int num : nums2) {
            mp2.put(num, mp2.getOrDefault(num, 0) + 1);
        }
        for(int num : nums1) {
            if(mp2.containsKey(num)) {
                int min = Math.min(mp1.get(num), mp2.get(num));
                mp2.remove(num);
                for(int i = 0; i < min; i++) {
                    list.add(num);
                }
            }
        }
        int[] ans = new int[list.size()];
        int pos = 0;
        for(int ele : list) {
            ans[pos] = ele;
            pos++;
        }
        return ans;
    }
}
