public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int i = 0, fitIndex = bSearch(nums, 0, nums.length - 1, target);
        
        if(fitIndex != -1) {
            while(fitIndex - i >= 0 && nums[fitIndex - i] == target) { ++i; }
            ans[0] = fitIndex - i + 1;
            i = 0;
            while(fitIndex + i < nums.length && nums[fitIndex + i] == target) { ++i; }
            ans[1] = fitIndex + i - 1;
        }
        return ans;
    }
    
    private int bSearch(int[] arr, int left, int right, int target) {
        if(arr[right] == target) { return right; }
        else if(arr[left] == target) { return left; }
        
        int mid = (left + right) / 2;
        if(mid == left) { return -1; }
        
        if(arr[mid] > target) { return bSearch(arr, left, mid, target); }
        else if(arr[mid] < target) { return bSearch(arr, mid, right, target); }
        else { return mid; }
    }
}
