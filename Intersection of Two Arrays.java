public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int length = Math.min(nums1.length, nums2.length);
        int[] ans = new int[length];
        int index = 0;
        HashSet<Integer> numberInTheShortArray = new HashSet<Integer>();
        
        if (nums1.length <= nums2.length) {
            for (int i = 0; i < nums1.length; ++i) {
                numberInTheShortArray.add(nums1[i]);
            }
            Arrays.sort(nums2);
            for (Integer number : numberInTheShortArray) {
                if (binarySearch(nums2, number)) {
                    ans[index] = number;
                    index++;
                }
            }
            
        } else {
            for (int i = 0; i < nums2.length; ++i) {
                numberInTheShortArray.add(nums2[i]);
            }
            System.out.println(numberInTheShortArray);
            Arrays.sort(nums1);
            for (Integer number : numberInTheShortArray) {
                if (binarySearch(nums1, number)) {
                    ans[index] = number;
                    index++;
                }
            }
        }
        int[] retVal = new int[index];
        for (int i = 0; i < retVal.length; ++i) {
            retVal[i] = ans[i];
        }
        
        return retVal;
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
