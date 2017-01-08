public class Solution {
    public char findTheDifference(String s, String t) {
        // create an array of size 26 to represent 26 characters.
        // scan s and increase 1 to the according array spot.
        // scan t and decrease 1 to the according array spot.
        // find that one with the value of -1 and return the according character.
        
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            sum += (int)s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++) {
            sum -= (int)t.charAt(i);
        }
        return (char)(-sum);
        
    }
}
