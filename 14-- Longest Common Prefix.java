public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) { return ""; }
        
        int min = Integer.MAX_VALUE;
        int index = 0;
        
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                index = i;
            }
        }
        
        String ans = strs[index];
        
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < ans.length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    ans = ans.substring(0, j);
                }
            }
        }
        
        return ans;
    }
}
