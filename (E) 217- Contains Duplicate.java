public class Solution {
    public boolean containsDuplicate(int[] nums) {
        // use hashset storing the element and the count
        // if it's already in the set, return true
        // otherwise after the scan, return false
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
