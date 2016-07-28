public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        String[] wordOfLetter = new String[25]; // simple mapping
        
        if (pattern.length() != strArr.length) { return false; }
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < strArr.length; i++) {
            int letter = pattern.charAt(i) - 'a';
            
            if (wordOfLetter[letter] == null) {
                
                if (set.contains(strArr[i])) { return false; }
                
                set.add(strArr[i]);
                wordOfLetter[letter] = strArr[i];
                
            } else if (!wordOfLetter[letter].equals(strArr[i])) {
                return false;
            }
        }
        
        return true;
    }
}
