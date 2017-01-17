public class Solution {
    public boolean isAnagram(String s, String t) {
        // Use array as a hashmap to store the count of each char in s.
        // scan t, and deduct the count in the array. if the char does not exist, return false
        // if the count becomes minus, return false
        
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < map.length; i++) {
            if(map[i] != 0) return false;
        }
        return true;
    }
}
