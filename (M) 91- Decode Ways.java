public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] opt = new int[s.length() + 1];
        opt[0] = 1;
        opt[1] = 1;
        
        for(int i = 2; i < opt.length; i++) {

            if(s.charAt(i - 1) == '0' ) {
                if(s.charAt(i - 2) == '0') { // two consecutive 0 would form no result.
                    return 0;
                }
                if(Character.getNumericValue(s.charAt(i - 2)) > 2) { // 50, 70, 80 etc are not available.
                    return 0;
                }
                opt[i] = opt[i -2];
                continue;
            } else {
                opt[i] = opt[i - 1];
            }
            
            if((Character.getNumericValue(s.charAt(i - 2)) * 10 +  Character.getNumericValue(s.charAt(i - 1))) <= 26 &&
            (Character.getNumericValue(s.charAt(i - 2)) * 10 +  Character.getNumericValue(s.charAt(i - 1))) >= 1 && s.charAt(i-2) != '0') {
                opt[i] += opt[i - 2];
            }
        }
        
        return opt[opt.length - 1];
    }
}
