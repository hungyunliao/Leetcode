public class Solution {
    public int reverse(int x) {
        
        boolean isMinus = x < 0 ? true : false;
        
        if (isMinus) { x *= -1; }
        
        int ans = 0;
        
        while (x != 0) {
            int temp = x % 10;
            if (ans > Integer.MAX_VALUE/10 || ans < 0) { return 0; }
            else { ans = ans * 10 + temp; }
            x /= 10;
        }
        
        return isMinus ? -ans : ans;
    }
}
