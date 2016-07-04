public class Solution {
    public boolean isPowerOfThree(int n) {
        if ( n <= 0 ||
             n%10 != 1 &&
             n%10 != 3 &&
             n%10 != 9 &&
             n%10 != 7 ) { return false; }
             
        HashSet<Integer> powerOfThree = new HashSet<Integer>();
        int storedValue = 1;
        int i = 1;
        while (i < 21) {
            powerOfThree.add(storedValue);
            storedValue *= 3;
            i++;
        }
        
        return powerOfThree.contains(n);
    }
}
