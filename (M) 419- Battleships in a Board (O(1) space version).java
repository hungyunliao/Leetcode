public class Solution {
    public int countBattleships(char[][] board) {
        int leng = board.length;
        int width = board[0].length;
        
        if(leng == 0 || width == 0) return 0;
        
        boolean k = false;
        
        int ans = 0;
        
        for(int row = 0; row < leng; row++) {
            for(int col = 0; col < width; col++) {
                if(board[row][col] == 'X') {
                    if(k == false && (row == 0 || board[row - 1][col] != 'X')) {
                        k = true;
                        ans++;
                    }
                } else {
                    k = false;
                }
            }
            k = false;
        }
        return ans;
    }
}
