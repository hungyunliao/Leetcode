public class Solution {
    public int lengthLongestPath(String input) {
        if(input.length() == 0) {
            return 0;
        }
        
        Map<Integer, Integer> set = new HashMap<>();
        
        int leng = input.length();
        int level = 0;
        int i = 0;
        
        int prevLevel = -1;
        int max = 0;
        boolean prevDot = false;
        
        while(i < leng) {
            int temp = 0;
            boolean dot = false;
            
            while(i < leng && input.charAt(i) != '\n') {
                if(input.charAt(i) == '\t') {
                    level++;
                } else {
                    temp += 1;
                }
                if(input.charAt(i) == '.') {
                    dot = true;
                }
                i++;
            }
            i++; // skip char '\n'
            
            if(level <= prevLevel && set.get(prevLevel) > max + 1 && prevDot) {
                max = set.get(prevLevel) - 1; // the last text file does not need '\', so minus 1
            }
            
            if(level == 0) {
                set.put(level, (temp + 1)); // add 1 is for the char '\' between dir
            }
            else {
                set.put(level, (temp + 1 + set.get(level - 1))); // add 1 is for the char '\' between dir
            }
            
            prevDot = dot;
            prevLevel = level;
            level = 0;
            
        }
        
        return max >= set.get(prevLevel)? max : (prevDot? (set.get(prevLevel) - 1) : max);
    }
}
