public class Solution {
    public int compareVersion(String version1, String version2) {
        int v1num = 0, v2num = 0;
        Stack<Integer> stk = new Stack<>();
        int pow = 1;
        
        int i = 0, j = 0;
        
        while (i < version1.length() || j < version2.length()) {
            while (i < version1.length() && version1.charAt(i) != '.') {
                stk.push(version1.charAt(i) - '0');
                i++;
            }
            while (stk.size() != 0) {
                v1num += stk.pop() * pow;
                pow *= 10;
            }
            pow = 1;
            
            while (j < version2.length() && version2.charAt(j) != '.') {
                stk.push(version2.charAt(j) - '0');
                j++;
            }
            while (stk.size() != 0) {
                v2num += stk.pop() * pow;
                pow *= 10;
            }
            pow = 1;
            
            if (v1num > v2num) {
                return 1;
            } else if (v1num < v2num) {
                return -1;
            } else {
                if (i < version1.length()) i++;
                if (j < version2.length()) j++;
            }
            
        }
        return 0;
        
    }
}
