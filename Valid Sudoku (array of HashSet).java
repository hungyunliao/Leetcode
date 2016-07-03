public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean isSuccess = true;
        // use the wildcard, but you will lose the type-safety
        HashSet<?>[] rows = new HashSet<?>[27]; // Wildcard: It's written Collection<?> (pronounced "collection of unknown"), that is, a collection whose element type matches anything. It's called a wildcard type for obvious reasons.
        for (int i = 0; i < rows.length; ++i) { rows[i] = new HashSet<Character>(); }
        
        // HashSet 0 - 8 are for Length comparison
        // HashSet 9 -17 are for Row comparison
        // HashSet 18-26 are for square comparison
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') { continue; }
                
                isSuccess &= ((HashSet<Character>)rows[i]).add(board[i][j]);
                isSuccess &= ((HashSet<Character>)rows[j+9]).add(board[i][j]);
                if (i < 3 && j < 3) { isSuccess &= ((HashSet<Character>)rows[18]).add(board[i][j]); } 
                else if (i < 3 && j < 6) { isSuccess &= ((HashSet<Character>)rows[19]).add(board[i][j]); }
                else if (i < 3 && j < 9) { isSuccess &= ((HashSet<Character>)rows[20]).add(board[i][j]); }
                else if (i < 6 && j < 3) { isSuccess &= ((HashSet<Character>)rows[21]).add(board[i][j]); }
                else if (i < 6 && j < 6) { isSuccess &= ((HashSet<Character>)rows[22]).add(board[i][j]); }
                else if (i < 6 && j < 9) { isSuccess &= ((HashSet<Character>)rows[23]).add(board[i][j]); }
                else if (i < 9 && j < 3) { isSuccess &= ((HashSet<Character>)rows[24]).add(board[i][j]); }
                else if (i < 9 && j < 6) { isSuccess &= ((HashSet<Character>)rows[25]).add(board[i][j]); }
                else if (i < 9 && j < 9) { isSuccess &= ((HashSet<Character>)rows[26]).add(board[i][j]); }
                
                if (!isSuccess) { return false; }
                
            }
        }
        
        return true;
    }
}
