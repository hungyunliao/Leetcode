public class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> str = new LinkedList<String>();
        
        if(nums.length == 0) { return str; }
        int rangeL = nums[0], rangeR = rangeL;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == rangeR + 1) { rangeR = nums[i]; }
            else {
                if(rangeR == rangeL) { str.add(Integer.toString(rangeL)); }
                else { str.add( rangeL + "->" + rangeR); }
                rangeL = nums[i];
                rangeR = rangeL;
            }
        }
        
        if(rangeR == rangeL) { str.add(Integer.toString(rangeL)); }
        else { str.add( rangeL + "->" + rangeR); }
        
        return str;
    }
}
