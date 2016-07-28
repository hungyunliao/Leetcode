public class Solution {
    public boolean isValid(String s) {
        
        Stack stk = new Stack();
        Map<Character, Character> map = new HashMap<>();
        
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        for (int i = 0; i < s.length(); i++) {
            
            if (map.containsKey(s.charAt(i))) {     // if the char is left parentheses
                stk.push(map.get(s.charAt(i)));
            } else {                                // if the char is right parenthese
                if (stk.size() == 0 || (char)stk.pop() != s.charAt(i)) {
                    return false;
                }
            }
            
        }
        
        return stk.size() == 0? true : false;
    }
}
