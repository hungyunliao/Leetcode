public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] opt = new int[s.length() + 1];
        opt[0] = 1;
        opt[1] = 1;
        
        for(int i = 2; i < opt.length; i++) {
            char currChar = s.charAt(i - 1);
            char prevChar = s.charAt(i - 2);
            int currCharInt = Character.getNumericValue(currChar);
            int prevCharInt = Character.getNumericValue(prevChar);
            int combineInt = prevCharInt * 10 + currCharInt;

            if(currChar == '0' ) {
                if(prevChar == '0' || prevCharInt > 2) { // two consecutive 0 would form no result. or 30, 40, 50 ... are not available.
                    return 0;
                }
                opt[i] = opt[i - 2]; // since the '0' must combine with the previous number to form a legal number, it is impossible for the previous number to be combined with another number. Therefore the opt[i] should be opt[i - 2] instead of opt[i - 1];
            } else {
                opt[i] = opt[i - 1];
                
                if(combineInt <= 26 && combineInt >= 1 && prevChar != '0') {
                    opt[i] += opt[i - 2];
                }
            }
        }
        
        return opt[opt.length - 1];
    }
}
