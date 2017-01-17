public class Solution {
    public int titleToNumber(String s) {
        // create a map [A:1, B:2, C:3 ... Z:26]
        // scan the s and calculate as a * 26^0 + b * 26^1 + c * 26^2 ...
        
        int[] map = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans += map[(int)(s.charAt(i) - 'A')] * Math.pow(26, s.length() - 1 - i);
        }
        return ans;
    }
}
