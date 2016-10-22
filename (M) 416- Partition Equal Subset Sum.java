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
        for(int i = 0; i <= sum/2; i++) {
            opt[i][0] = false;
        }
        
        // Init first col. Given any array, all can form the sum of '0' (Don't select anything.)
        for(int j = 0; j <= nums.length; j++) {
            opt[0][j] = true;
        }
        
        /*
            The goal is to pick element in the array to another array Left, and the leftover elements will be the array Right,
            so we want to see whether we can pick elements in the given array (nums[0] to nums[n]) to reach sum/2, which means the leftover elements will also from sum/2.
            The subproblem is to exam whether the given array (0 to i) can form the given sum.
            
            
            The recurence will be:
            nums[last one available] : the last element in the given array
            opt(i, j) = opt(i - 1, j) || opt(i - 1, j - nums[last one available])
            opt(i - 1, j): if the last element is not picked, the sum is the same, the subproblem is like opt(i - 1, j)
            opt(i - 1, j - nums[last one available]): if the last element is picked, the sum will be j - nums[last one available] for the subproblem.
        */
        
        for(int j = 1; j <= nums.length; j++) {
            for(int i = 1; i <= sum/2; i++) {
                
                int x = j - 1;
                if(nums[x] > sum/2) {
                    return false;
                }
                if((i - nums[x]) >= 0) {
                    opt[i][j] = opt[i][j - 1] || opt[i - nums[x]][j - 1];
                } else {
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
