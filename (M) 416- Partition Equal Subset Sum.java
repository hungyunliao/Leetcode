public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum%2 != 0) {
            return false;
        }
        
        boolean opt[][] = new boolean[sum/2 + 1][nums.length + 1];
        // dp[i][j] means given first 'i' element in the nums, can you use any of them to form the sum 'j'? If yes, True, False otherwise. (You can use some of the elements given, no need to use all of them)
        
        // Init first row. Given any sum, if you have an empty array, you cannot form anything.
        for(int j = 0; j <= sum/2; j++) {
            opt[j][0] = false;
        }
        
        // Init first col. Given any array, all can form the sum of '0' (Don't select anything.)
        for(int i = 0; i <= nums.length; i++) {
            opt[0][i] = true;
        }
        
        /*
            The recurence will be:
            opt(i, j) = opt(i - 1, j) || opt(i - 1, j - nums[0 to n - 1])
            opt(i - 1, j): if given array length (i) cannot form the sum, the ans is simply like the previous one.
            opt(i - 1, j - nums[0 to n]): if the given array length(i) can form the sum, meaning that you can find one j - nums[x] (x is from 0 to n-1) which forms the small subproblem with array size i - 1 and sum = j - element.
        */
        
        for(int j = 1; j <= nums.length; j++) {
            for(int i = 1; i <= sum/2; i++) {
                for(int x = (j - 1); x < j; x++) {
                    if(nums[x] > sum/2) {
                        return false;
                    }
                    if((i - nums[x]) >= 0) {
                        opt[i][j] = opt[i][j - 1] || opt[i - nums[x]][j - 1];
                    }
                    else {
                        opt[i][j] = opt[i][j - 1];
                }
            }
        }
        
        // for(boolean[] arr:opt) {
        //     for(boolean cell: arr) {
        //         System.out.print(cell + " ");
        //     }
        //     System.out.println();
        // }
        
        return opt[sum/2][nums.length];
        
    }
}
