public class Solution {
    public int getSum(int a, int b) {
        
        if (b == 0) { return a; }
        int sum = a ^ b;
        int plusOne = 0;
        
        for (int i = 0; i < 31; ++i) {
            if((sum & 1<<i) == 0 && (a & 1<<i) == (1<<i)) {
                plusOne |= 1<<(i+1);
            }
        }
        a = sum;
        b = plusOne;
        
        return getSum(a, b);
    }
}
