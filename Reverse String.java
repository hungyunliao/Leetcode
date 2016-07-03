public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        int leng = s.length();
        for (int i = leng - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
