public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || target > nums[nums.length - 1]) { return nums.length; }
        return bSearch(nums, 0, nums.length - 1, target);
    }
    
    private int bSearch(int[] arr, int left, int right, int target) {
        if(arr[right] == target) { return right; }
        else if(arr[left] == target) { return left; }
        
        int mid = (left + right) / 2;
        if(mid == left) { return arr[mid] > target ? left : left + 1; }
        
        if(arr[mid] > target) { return bSearch(arr, left, mid, target); }
        else if(arr[mid] < target) { return bSearch(arr, mid, right, target); }
        else { return mid; }
    }
}
