public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int retVal = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) == (1 << i)) {
                retVal = retVal | (1 << (31 - i));
            }
        }
        return retVal;
    }
}
