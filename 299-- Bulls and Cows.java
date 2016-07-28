public class Solution {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        char[] sec = secret.toCharArray();
        char[] gue = guess.toCharArray();
        int A = 0, B = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        /*
            hashmap-> Key: the digit, Value: appear times
            secret: increase the appear times. If the appear times before increment is < 0, meaning that there is the same digit appeared in "guess", so increase B.
            guess: decrease the appear times. If the appear times before decrement is > 0, meaning that there is the same digit appeared in "secret", so increase B.
        */
        
        for (int i = 0; i < length; i++) {
            if (sec[i] == gue [i]) {
                A++;
            } else {
                if (!map.containsKey(gue[i])) {
                    map.put(gue[i], -1);
                } else {
                    if (map.get(gue[i]) > 0) { B++; }
                    map.put(gue[i], map.get(gue[i]) - 1);
                }
                
                if (!map.containsKey(sec[i])) {
                    map.put(sec[i], 1);
                } else {
                    if (map.get(sec[i]) < 0) { B++; }
                    map.put(sec[i], map.get(sec[i]) + 1);
                }
            }
        }
        
        return A + "A" + B + "B";
    }
}
