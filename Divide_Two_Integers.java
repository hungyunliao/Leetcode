public class Solution {
    public int divide(int dividend, int divisor) {
        // Switch both the dividend and divisor to the negative number to make the calculation easier. All the positive number can be switched to the negative one since the MAX_VALUE = 2147483647; however, not the other way around. Not all of the negative number can be switched to the positive one like MIN_VALUE = -2147483648.
        int ans = 0;
        int n = 0;
        boolean shouldBeNegative = false;
        
        if (dividend > 0) {
            shouldBeNegative = true; // need to change the sign of the answer to negative.
            dividend *= -1;
        }
        if (divisor > 0) {
            divisor *= -1;
            if (shouldBeNegative) { shouldBeNegative = false; } // need to change the sign back to positive
            else { shouldBeNegative = true; }
        }
        
        int originalDivisor = divisor;
        
        // Ex: dividend = 10, divisor = 1:
        // 1st Round: 10 - 1 = 9, ans + 1 = 1, divisor * 2 = 2
        // 2nd Round: 9  - 2 = 7, ans + 2 = 3, divisor * 2 = 4
        // 3rd Round: 7  - 4 = 3, ans + 4 = 7, divisor * 2 = 8
        // 4th Round: 3  - 8 = -5, divisor = 1
        // 5th Round: 3  - 1 = 2, ans + 1 = 8, divisor * 2 = 2
        // 6th Round: 2  - 2 = 0, ans + 2 = 10
        // return the ans 10
        while(dividend <= divisor) {
            
            dividend -= divisor;
            ans += 1<<n;
            divisor = divisor<<1;
            
            if (divisor >= 0) { divisor = Integer.MIN_VALUE; }
            
            n += 1;
            if (dividend - divisor > 0) {
               if (divisor == originalDivisor) { break; }
               divisor = originalDivisor;
               n = 0;
            }
        }
        
        if ((ans - 1) == Integer.MAX_VALUE && !shouldBeNegative) { ans = Integer.MAX_VALUE; } // Overflowed
        
        return shouldBeNegative? ans*-1 : ans;
    }
}
