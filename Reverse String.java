public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        // Faster than using s.charAt(i)
        char[] sArray = s.toCharArray();
        for (int i = sArray.length - 1; i >= 0; --i) {
            sb.append(sArray[i]);
        }
        return sb.toString();
    }
}
