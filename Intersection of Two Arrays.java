public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) { return null; }
        int[] ans = new int[nums1.length];
        int index = 0;
        HashSet<Integer> numberInTheShortArray = new HashSet<Integer>();
        
        // Algo:
        // 1. remove the duplicate elements in the nums1 (hs)
        // 2. binary search each elements in the hs in within nums2. If returning true, add it into the ans array
        // 3. trim the ans array by Arrays.copyOf Range
        for (int i = 0; i < nums1.length; ++i) { numberInTheShortArray.add(nums1[i]); }
        index = saveTheIdenticalNumberInHashSet(numberInTheShortArray, nums2, ans);
        
        // trim the array to avoid showing the value of '0's
        return Arrays.copyOfRange(ans, 0, index); // return a new array with the length of index - 0
    }
    
    public int saveTheIdenticalNumberInHashSet(HashSet<Integer> hs, int[] array, int[] ans) {
        int index = 0;
        Arrays.sort(array);
        for (Integer number : hs) {
            if (binarySearch(array, number)) {
                ans[index] = number;
                index++;
            }
        }
        return index;
    }
    
    public boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right)/2;
            if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
