public class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase();
        
        for (int i = 0, j = str.length() - 1; i < j;) {
            while ((str.charAt(i) < 'a' || str.charAt(i) >  'z') && (str.charAt(i) < '0' || str.charAt(i) >  '9')) {
                i++;
                if (i > j) {
                    return true;
                }
            }
            while ((str.charAt(j) < 'a' || str.charAt(j) >  'z') && (str.charAt(j) < '0' || str.charAt(j) >  '9')) {
                j--;
                if (i > j) {
                    return true;
                }
            }
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
