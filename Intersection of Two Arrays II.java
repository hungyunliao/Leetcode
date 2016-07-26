public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        
        /*
            store the value into a hashMap: 'Key' is the number and 'Value' is the appearance times the number appeared.
        */
        for (int i = 0; i < nums1.length; ++i) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        
        int[] ansRaw = new int[nums1.length];
        int index = 0;
        
        /*
            scan the other array.
            examine wether the value appears in the hashMap, if it does, decrement the value of that key.
            if the value reach 0 meaning it needn't be shown anymore.
        */
        for (int i = 0; i < nums2.length; ++i) {
            if (map.containsKey(nums2[i]) && (map.get(nums2[i]) != 0)) {
                ansRaw[index++] = nums2[i];
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        
        int[] ans = new int[index];
        
        for (int i = 0; i < index; ++i) {
            ans[i] = ansRaw[i];
        }
        
        return ans;
    }
}
