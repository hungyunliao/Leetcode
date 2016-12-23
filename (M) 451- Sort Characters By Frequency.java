public class Solution {
    public String frequencySort(String s) {
        int[] arr = new int[256];
        for(int i = 0; i < s.length(); i++) {
            arr[(int)s.charAt(i)]++;
        }
        Map<Integer, List<Character>> mp = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!mp.containsKey(arr[i])) {
                mp.put(arr[i], new ArrayList<Character>());
            } 
            mp.get(arr[i]).add((char)i);
        }
        Set<Integer> filter = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(!filter.contains(arr[i])) {
                filter.add(arr[i]);
            }
        }
        int[] freq = new int[filter.size()];
        int index = 0;
        for (Integer num : filter) {
            freq[index] = num;
            index++;
        }
        
        String ans = "";
        Arrays.sort(freq);
        for(int i = freq.length - 1; i >= 0 && freq[i] != 0; i--) {
            for(char c : mp.get(freq[i])) {
                ans += printChar(c, freq[i]);
            }
        }
        
        return ans;
    }
    
    private String printChar(char a, int times) {
        StringBuilder sb = new StringBuilder(); // must use StringBuilder in this problem, otherwise TLE
        for(int i = 0; i < times; i++) {
            sb.append(a);
        }
        return sb.toString();
    }
}
