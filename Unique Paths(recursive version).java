public class Solution {
    int count = 0;
    
    public int uniquePaths(int m, int n) {
        maze(m, n);
        return count;
    }
    
    private void maze(int m, int n) {
        if(m == 1 || n == 1) { 
            count++;
            return; 
        }
        if(m < 1 || n < 1) { return; }
        maze(m - 1, n);
        maze(m, n - 1);
    }
}


public class Solution {
    int count = 0;
    
    public int uniquePaths(int m, int n) {
        maze(m, n);
        return count;
    }
    
    private void maze(int m, int n) {
        if(m == 4) {
            for(int i = n; i > 0; i--) {
                count += cal(i);
            }
            return;
        }
        if(n == 4) {
            for(int i = m; i > 0; i--) {
                count += cal(i);
            }
            return;
        }
        
        if(m < 1 || n < 1) { return; }
        maze(m - 1, n);
        maze(m, n - 1);
    }
    private int cal(int k) {
        int sum = 0;
        for(int i = 1; i <= k; i++) {
            sum += i;
        }
        return sum;
    }
}
