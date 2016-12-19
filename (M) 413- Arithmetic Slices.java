public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int leng = A.length;
        if(leng < 3) {
            return 0;
        }
        
        int diff = A[1] - A[0];
        
        int[] opt = new int[A.length];
        opt[0] = 0;
        opt[1] = 0;
        if(isArithmetics(Arrays.copyOfRange(A, 0, 3))) {
            opt[2] = 1;
        }
        
        for(int i = 3; i < opt.length; i++) {
            if(isArithmetics(Arrays.copyOfRange(A, i - 2, i + 1))) {
                opt[i] = 2 * opt[i - 1] + 1 - opt[i - 2];
            } else {
                opt[i] = opt[i - 1];
            }
        }
        
        return opt[opt.length - 1];
    }
    
    private boolean isArithmetics(int[] sub) {
        
        int diff = sub[1] - sub[0];
        for(int i = 1; i < sub.length - 1; i++) {
            if(sub[i + 1] - sub[i] != diff) {
                return false;
            }
        }
        
        return true;
    }
}
