public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sleng = s.length();
        int tleng = t.length();
        
        if(sleng != 0 && tleng == 0) {
            return false;
        }
        
        int i = 0, j = 0;
        
        while(i < sleng) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
            if(j == tleng && i < sleng) {
                return false;
            }
        }
        return true;
    }
}
