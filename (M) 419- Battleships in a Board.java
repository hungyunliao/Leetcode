public class Solution {
    public int countBattleships(char[][] board) {
        int leng = board.length;
        int width = board[0].length;
        
        if(leng == 0 || width == 0) return 0;
        
        boolean[] row = new boolean[width];
        for(int i = 0; i < row.length; i++) row[i] = false;
        
        int ans = 0;
        
        for(int i = 0; i < leng; i++) {
            for(int j = 0; j < width; j++) {
                if(board[i][j] == 'X' && row[j] == false) {
                    row[j] = true;
                    if(!isLeftTrue(row, j)) ans++;
                } else if(board[i][j] == '.') {
                    row[j] = false;
                }
            }
        }
        
        return ans;
    }
    
    public boolean isLeftTrue(boolean[] row, int j) {
        int width = row.length;
        
        if(j == 0 || width == 1) return false;
        
        if(row[j - 1] == true) return true;
        else return false;
    }
}
