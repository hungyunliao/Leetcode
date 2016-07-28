public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) { return false; }
        
        if (num == 1) { return true; }
        
        if (1073741824%num == 0) { // num is the power of 2
            if (num%10 == 4 || num%10 == 6) { // the two end-digit for the power of 4
                return true;
            }
            return false;
        }
        
        return false;
    }
}
