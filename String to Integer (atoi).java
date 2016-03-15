public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        double number = 0; // must use double otherwise the negative number will be restricted to -2147483647
        int times = str.length() - 1, minus = 0, i = 0;
        //number = (int) (str.charAt(0) - 48);
        
        if(str.equals("")) { return 0; }
        
        if(str.charAt(0) == '-') {
            minus = 1;
            i = 1;
            times--;
        } else if (str.charAt(0) == '+') {
            i = 1;
            times--;
        }
        
        for (i = i; i < str.length(); i++) {
                if( (int) (str.charAt(i) - 48) < 0 || (int) (str.charAt(i) - 48) > 9 ) {
                    number /= Math.pow(10, times + 1);
                    break;
                }
                number += (int) (str.charAt(i) - 48) * Math.pow(10, times);
                times--;
        }
        
        if(minus == 1) { number *= -1; }
        if(number <= Integer.MIN_VALUE) { number = Integer.MIN_VALUE; }
        if(number >= Integer.MAX_VALUE) { number = Integer.MAX_VALUE; }
        return (int)number;
    }
}
