public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        //str += (char) 49; // add 48 to an int to cast it to char (ASCII code)
        for (int i = 0; i < n - 1; i++) {
            str = helper(str);
        }
        return str;
    }
    private String helper(String str) {
        int count = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i < str.length()) {
            char now = str.charAt(i);
            count++;
            i++;
            
            while(i < str.length() && str.charAt(i) == now) {
                i++;
                count++;
            }
            
            sb.append((char)(48 + count)).append(now);
            count = 0;
        }
        return sb.toString();
    }
}
