public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int width = board[0].length;
        boolean ans = true;
        
        for (int i = 0; i < 9; i++) {
            ans = helper(board, i, 0, i, 8);
            if (!ans) { return ans; }
            ans = helper(board, 0, i, 8, i);
            if (!ans) { return ans; }
            if (i == 0 || i == 3 || i == 6) {
                ans = helper2(board, i, 0);
                if (!ans) { return false; }
                ans = helper2(board, i, 3);
                if (!ans) { return false; }
                ans = helper2(board, i, 6);
                if (!ans) { return false; }
            }
        }
        return true;
    }
    
    public boolean helper(char[][] board, int startLeng, int startWidth, int endLeng, int endWidth) {
        HashSet hs = new HashSet();
        if (startLeng == endLeng) {
            int currWidth = startWidth;
            while (currWidth <= endWidth) {
                if(board[startLeng][currWidth] != '.' && hs.contains(board[startLeng][currWidth])) {
                    return false;
                } else {
                    hs.add(board[startLeng][currWidth]);
                }
                currWidth += 1;
            }
        } else {
            int currLeng = startLeng;
            while (currLeng <= endLeng) {
                if(board[currLeng][startWidth] != '.' && hs.contains(board[currLeng][startWidth])) {
                    return false;
                } else {
                    hs.add(board[currLeng][startWidth]);
                }
                currLeng += 1;
            }
        }
        return true;
    }
    
    public boolean helper2(char[][] board, int startLeng, int startWidth) {
        HashSet hs = new HashSet();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startLeng + i][startWidth + j] != '.' && hs.contains(board[startLeng + i][startWidth + j])) {
                    return false;
                } else {
                    hs.add(board[startLeng + i][startWidth + j]);
                }
            }
        }
        return true;
    }
}
