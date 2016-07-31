public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        char temp = '0';
        String ans = "";
        
        while (i >= 0 && j >= 0) {
            int numsOfOne = 0;
            if (a.charAt(i) == '1') { numsOfOne++; }
            if (b.charAt(j) == '1') { numsOfOne++; }
            if (temp == '1') { numsOfOne++; }
            
            switch (numsOfOne) {
                case 0:
                    ans = "0" + ans;
                    break;
                case 1:
                    temp = '0';
                    ans = "1" + ans;
                    break;
                case 2:
                    temp = '1';
                    ans = "0" + ans;
                    break;
                case 3:
                    temp = '1';
                    ans = "1" + ans;
                    break;
                default:
                    break;
            }
            i--;
            j--;
        }
        
        while (i >= 0) {
            if (temp == '1' && a.charAt(i) == '1') {
                temp = '1';
                ans = "0" + ans;
            } else {
                if (temp == '1') { temp = '0'; ans = '1' + ans; }
                else ans = a.charAt(i) + ans;
            }
            i--;
        }
        
        while (j >= 0) {
            if (temp == '1' && b.charAt(j) == '1') {
                temp = '1';
                ans = "0" + ans;
            } else {
                if (temp == '1') { temp = '0'; ans = '1' + ans; }
                else ans = b.charAt(j) + ans;
            }
            j--;
        }
        
        if (temp == '1') {
            ans = temp + ans;
        }
        
        return ans;
    }
}
