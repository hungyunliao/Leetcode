public class Solution {
    public int findComplement(int num) {
        // scan from the front to see which bit gets the first '1', and record its location
        // reverse the bit one by one from the end
        int leadingBit = 0, ans = 0;
        for(int i = 31; i >= 0; i--) {
            if(((num >> i) & 1) == 1) {
                leadingBit = i;
                break;
            }
        }
        for(int i = 0; i <= leadingBit; i++) {
            ans |= ((num ^ (1 << i)) & (1 << i));
        }
        return ans;
    }
}
