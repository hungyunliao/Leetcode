public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<String>();
        
        for(String s:path.split("/")) {
            if(s.length() == 0) {
                continue;
            }
            if(s.equals("..")) {
                if(stk.size() > 0) {
                    stk.pop();
                }
            } else if(s.equals(".")) {
                continue;
            } else {
                stk.push(s);
            }
        }
        String ans = stk.size() == 0? "/":"";
        while(stk.size() > 0) {
            ans = "/" + stk.pop() + ans;
        }
        
        return ans;
    }
}
