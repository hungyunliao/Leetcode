public class Solution {
    public List<String> readBinaryWatch(int num) {
        // use bit manipulation
        // 1 means the LED which is on
        // a helper function "timeValidation" validate whether the time is valid
        int time = 0;
        List<String> ans = new ArrayList<>();
        
        dfs(ans, num, time, 0);
        
        return ans;
    }
    
    private void dfs(List<String> ans, int num, int time, int index) {
        if(num == 0) {
            int hr = 0, min = 0;
            for(int i = 0; i < 32; i++) {
                if(((time >> i) & 1) == 1) {
                    if(i <= 3) {
                        hr += Math.pow(2, i);
                    } else {
                        min += Math.pow(2, (i - 4));
                    }
                }
            }
            if(timeValidation(hr, min)) {
                StringBuilder str = new StringBuilder();
                if(min / 10 == 0) {
                    str.append(Integer.toString(hr) + ":0" + Integer.toString(min));
                } else {
                    str.append(Integer.toString(hr) + ":" + Integer.toString(min));
                }
                
                ans.add(str.toString());
                return;
            } 
            return;
        }
        
        for(int i = index; i <= 10 - num; i++) {
            time = time | (1 << i);
            dfs(ans, num - 1, time, i + 1);
            time = time ^ (1 << i);
        }
    }
    
    private boolean timeValidation(int hr, int min) {
        if(hr >= 0 && hr <= 11 && min >= 0 && min <= 59) {
            return true;
        }
        return false;
    }
}
