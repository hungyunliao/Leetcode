/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int guessRet = 1;
        int left = 1, right = n;
        
        /* use the concept of Binary Search 
            change the range of binary search depends on the result return from the API.
        */
        while(guessRet != 0) {
            guessRet = guess(middleValueOfRange(left, right));
            
            if(guessRet == 1) {
                left = middleValueOfRange(left, right) + 1;  
            } else if(guessRet == -1) {
                right = middleValueOfRange(left, right) - 1;
            }
            
        }
        return middleValueOfRange(left, right);
    }
    
    public int middleValueOfRange(int left, int right) {
        return left + (right - left)/2; // cannot use (left + right)/2 because that would exceed the MAX_INT.
    }
}
