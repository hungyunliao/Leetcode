public class Solution {
    public int countSegments(String s) {
        // scan the string char by char
        // if it's a " ", make the flag true
        // if the flag is true and the char is not a " ", count++ and make the flag flase
        boolean wasSpace = true;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(wasSpace && s.charAt(i) != ' ') {
                wasSpace = false;
                ans++;
            }
            if(s.charAt(i) == ' ') {
                wasSpace = true;
            }
        }
        return ans;
    }
}
