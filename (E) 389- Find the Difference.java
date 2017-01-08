public class Solution {
    public char findTheDifference(String s, String t) {
        // create an array of size 26 to represent 26 characters.
        // scan s and increase 1 to the according array spot.
        // scan t and decrease 1 to the according array spot.
        // find that one with the value of -1 and return the according character.
        
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i) - 97;
            freq[index]++;
        }
        for(int i = 0; i < t.length(); i++) {
            int index = (int)t.charAt(i) - 97;
            freq[index]--;
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i] < 0) {
                return (char)(i + 97);
            }
        }
        return 'w'; // error happens
        
    }
}
