public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // sort g and s
        // use greedy algo. assign the smallest s to the smallest g
        // repeat 2 until g or s is empty.
        
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0, indexS = 0, ans = 0;
        while(indexG < g.length && indexS < s.length) {
            if(s[indexS] >= g[indexG]) {
                indexS++;
                indexG++;
                ans++;
            } else {
                indexS++;
            }
        }
        return ans;
    }
}
