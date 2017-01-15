public class Solution {
    public String toHex(int num) {
        // transfer num from binary to hex
        // 2^0, 2^1, 2^2, 2^3 (0-15 * 1) 2^4, 2^5, 2^6, 2^7 (0-15 * 16) etc.
        int times = 0, count = 0;
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i < 32; i++) {
            if(((num >> i) & 1) == 1) {
                count += Math.pow(2, i % 4);
            }
            
            if(++times == 4) {
                times = 0;
                str.insert(0, addString(count));
                count = 0;
            }
            
        }
        while(str.charAt(0) == '0' && str.length() > 1) {
            str.deleteCharAt(0);
        }
        return str.toString();
    }
    
    private String addString(int num) {
        StringBuilder str = new StringBuilder();
        if(num < 10) {
            str.append((char)(num + 48));
        } else {
            str.append((char)(num + 87));
        }
        return str.toString();
    }
}
