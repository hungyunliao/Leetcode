public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int pLeng = p.length();
        int sLeng = s.length();
        
        if(sLeng < pLeng) return ans;
        
        for(int i = 0; i < pLeng; i++) {
            char currChar = p.charAt(i);
            
            if(map.containsKey(currChar)) map.put(currChar, map.get(currChar) - 1);
            else map.put(currChar, -1);
        }
        
        for(int i = 0; i < pLeng; i++) {
            char currChar = s.charAt(i);
            
            if(map.containsKey(currChar)) map.put(currChar, map.get(currChar) + 1);
        }
        
        if(!isContainNegative(map)) ans.add(0);
        
        for(int i = 1; i + pLeng - 1 < sLeng; i++) {
            char prevChar = s.charAt(i - 1);
            char nextChar = s.charAt(i + pLeng - 1);
            
            if(map.containsKey(prevChar)) {
                map.put(prevChar, map.get(prevChar) - 1);
            }
            if(map.containsKey(nextChar)) {
                map.put(nextChar, map.get(nextChar) + 1);
            }
            
            if(!isContainNegative(map)) ans.add(i);
        }
        
        return ans;
    }
    
    // Note: need to understand what a collection "Object<>" means, and how to iterate it?
    
    public boolean isContainNegative(Map<Character, Integer> map) {
        for(Integer cell: map.values()) {
            if(cell < 0) return true;
        }
        return false;
    }
}
