public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int length = Math.min(nums1.length, nums2.length);
        int[] ans = new int[length];
        int index = 0;
        HashSet<Integer> numberInTheShortArray = new HashSet<Integer>();
        
        if (nums1.length <= nums2.length) {
            for (int i = 0; i < nums1.length; ++i) { numberInTheShortArray.add(nums1[i]); }
            index = saveTheIdenticalNumberInHashSet(numberInTheShortArray, nums2, ans);
            
        } else {
            for (int i = 0; i < nums2.length; ++i) { numberInTheShortArray.add(nums2[i]); }
            index = saveTheIdenticalNumberInHashSet(numberInTheShortArray, nums1, ans);
        }
        
        int[] retVal = new int[index];
        for (int i = 0; i < retVal.length; ++i) { retVal[i] = ans[i]; }
        
        return retVal;
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
