public class Solution {
    public String convert(String s, int numRows) {
        
        if (s.length() == 0) {
            return "";
        } else if (numRows == 1) {
            return s;
        }
        
        int numberOfRow = 0;
        int round = 0;
        String[] map = new String[numRows];
        for (int i = 0; i < map.length; i++) {
            map[i] = "";
        }
        
        for (int i = 0; i < s.length(); i++) {
            
            map[numberOfRow] += s.charAt(i);
            
            if (i >= ((numRows + numRows - 2) * round)) {
                numberOfRow++;
            } else {
                numberOfRow--;
            }
            if (numberOfRow == numRows - 1) {
                round++;
            }
        }
        
        String ans = "";
        
        for (int i = 0; i < numRows; i++) {
            ans += map[i];
        }
        
        return  ans;
    }
}
