public class Solution {
    public int[] countBits(int num) {
        
        int[] ans = new int[num + 1];
        int index = 0;
        int power = 1;
        
        /*
            pattern:
            [0]
            [0,  1] -> append previous array(0) + 1
            [0,1,  1,2] -> append previous array(0,1) + 1
            [0,1,1,2,  1,2,2,3] -> append previous array(0,1,1,2) + 1
        */
        
        for (int i = 1; i <= num; i++) {
            
            ans[i] = ans[index++] + 1;
            
            if (i == (power*2 - 1)) {
                index = 0;
                power *= 2;
            }
        }
        
        return ans;
    }
}
