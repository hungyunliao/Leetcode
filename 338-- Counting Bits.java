public class Solution {
    public int[] countBits(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int index = 0;
        int power = 1;
        
        for (int i = 1; i <= num; i++) {
            map.put(i, map.get(index++) + 1);
            
            if (i == (power*2 - 1)) {
                index = 0;
                power *= 2;
            }
        }
        
        int[] ans = new int[num+1];
        for (int i = 0; i <= num; i++) {
            ans[i] = map.get(i);
        }
        return ans;
    }
}
