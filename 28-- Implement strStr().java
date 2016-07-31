public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            String temp = haystack.substring(i, i+needle.length());
            if (temp.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}
