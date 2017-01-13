public class Solution {
    public String addStrings(String num1, String num2) {
        // scan the input from back to the front.
        // use Integer.valueOf("1") to convert to numeric values.
        // create another int for carrying.
        
        StringBuilder ans = new StringBuilder();
        int index1 = num1.length() - 1, index2 = num2.length() - 1, carry = 0;
        while(index1 >= 0 || index2 >= 0) {
            int number1 = (index1 < 0)? 0 : Character.getNumericValue(num1.charAt(index1));
            int number2 = (index2 < 0)? 0 : Character.getNumericValue(num2.charAt(index2));
            int sum = number1 + number2 + carry;
            if(sum / 10 >= 1) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.insert(0, String.valueOf(sum));
            if(index1 >= 0) index1--;
            if(index2 >= 0) index2--;
        }
        if(carry == 1) {
            ans.insert(0, String.valueOf(1));
        }

        return ans.toString();
    }
}
