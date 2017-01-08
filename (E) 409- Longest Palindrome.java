public class Solution {
    public int longestPalindrome(String s) {
        // create an array w/ size of 52 (upper case and lower case)
        // count the number of each characters
        // if one character appears 2*n times, then 2*n can be added to ans
        // at most one character can appear once
        int[] freq = new int[58];
        boolean isSingle = false;
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
        }
        for(int i = 0; i < freq.length; i++) {
            if(!isSingle && freq[i] % 2 == 1) {
                isSingle = true;
            }
            ans += freq[i] / 2 * 2;
        }
        return isSingle? ans + 1 : ans;
    }
}
