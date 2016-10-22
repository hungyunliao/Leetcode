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
            } else if(!s.equals(".")) {
                stk.push(s);
            } 
        }
        String ans = "";
        while(stk.size() > 0) {
            ans = "/" + stk.pop() + ans;
        }
        
        return ans.equals("")? "/":ans;
    }
}
