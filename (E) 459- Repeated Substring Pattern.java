public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        // appear times need to be equal for each char
        // str.length() % pattern.length() == 0
        
        int subTo = str.length() / 2;
        String sub = "";
        
        do {
            sub = str.substring(0, subTo);
            if(sub.length() != 0 && str.length() % sub.length() == 0) {
                if(isMultiple(str, sub)) {
                    return true;
                }
            }
            subTo--;
        } while(sub.length() > 0);
        
        return false;
        
    }
    
    private boolean isMultiple(String str, String sub) {
        int multiple = str.length() / sub.length();
        StringBuilder retString = new StringBuilder();
        for(int i = 0; i < multiple; i++) {
            retString.append(sub);
        }
        return retString.toString().equals(str);
    }
}
