public class Solution {
    int count = 0; // global variable
    
    public int countArrangement(int N) {
        /*
            use standard back-tracking:
            keep a boolean array to see which number is used.
            if the number is not in use, pick it and to see whether it conforms to two rules? if yes, add it and go to next position, otherwise, skip it.
        
        */
        boolean[] number = new boolean[N + 1];  // boolean array is initialized as false, so here false means not in use.
        backTracking(N, number, 1);
        return count;
    }
    
    public void backTracking(int N, boolean[] number, int position) {
        // base case
        if(position > N) {
            count++;
            return;
        }
        
        // normal case
        for(int i = 1; i <= N; i++) {
            if(!number[i] && (i % position == 0 || position % i == 0)) {
                number[i] = true;
                backTracking(N, number, position + 1);
                number[i] = false;
            }
        }
    }
}
