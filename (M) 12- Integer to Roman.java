public class Solution {
    public String intToRoman(int num) {
        int num1 = num;
        int thousand = num1/1000;
        num1 %= 1000;
        int hundred = num1/100;
        num1 %= 100;
        int ten = num1/10;
        num1 %= 10;
        int digit = num1;
        
        String ans = "";
        ans += printRoman("M", thousand);
        ans += printRoman("CDM", hundred);
        ans += printRoman("XLC", ten);
        ans += printRoman("IVX", digit);
        
        return ans;
    }
    
    private String printRoman(String character, int number) {
        int belongToCase = number;
        if(number == 1 || number == 2 || number == 3) {
            belongToCase = 1;
        } else if(number == 6 || number == 7 || number == 8) {
            belongToCase = 6;
        }
        
        String str = "";
        
        switch (belongToCase) {
            case 0:
                break;
            case 1:
                while(number-- != 0) {
                    str += character.charAt(0);
                }
                break;
            case 4:
                str += character.charAt(0);
                str += character.charAt(1);
                break;
            case 5:
                str += character.charAt(1);
                break;
            case 6:
                str += character.charAt(1);
                number -= 5;
                while(number-- != 0) {
                    str += character.charAt(0);
                }
                break;
            case 9:
                str += character.charAt(0);
                str += character.charAt(2);
                break;
        }
        return str;
    }
}
