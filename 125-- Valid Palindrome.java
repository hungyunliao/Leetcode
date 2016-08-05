public class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase();
        
        for (int i = 0, j = str.length() - 1; i < j;) {
            while ((str.charAt(i) < 97 || str.charAt(i) >  122) && (str.charAt(i) < 48 || str.charAt(i) >  57)) {
                i++;
                if (i > j) {
                    return true;
                }
            }
            while ((str.charAt(j) < 97 || str.charAt(j) >  122) && (str.charAt(j) < 48 || str.charAt(j) >  57)) {
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
