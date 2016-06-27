public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> nineDigitRemained = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            nineDigitRemained.add(i);
        }
        List<Integer> tempAns = new ArrayList<Integer>();
        List<List<Integer>> retval = new ArrayList<List<Integer>>();
        
        for (int i = 9; i > k; i--) {
            List<Integer> ans = new ArrayList<Integer>();
            tempAns = helper(nineDigitRemained, k, n, ans);
            if (!retval.contains(tempAns)) {
                retval.add(tempAns);
            }
            retval.remove(null);
            nineDigitRemained.clear();
            for (int j = 1; j < i; j++) {
                nineDigitRemained.add(j);
            }
        }
        
        return retval;
    }
    
    public List<Integer> helper(List<Integer> remained, int k, int n, List<Integer> singleAnsCombination) {
        int left = 0;
        int right = remained.size() - 1;
        
        if (k == 2) {
            
            while (left != right) {
                if (remained.get(left) + remained.get(right) == n) {
                    singleAnsCombination.add(remained.get(left));
                    singleAnsCombination.add(remained.get(right));
                    Collections.sort(singleAnsCombination);
                    return singleAnsCombination;
                } else if (remained.get(left) + remained.get(right) > n) {
                    right--;
                } else {
                    left++;
                }
            }
            singleAnsCombination.clear();
            return null;
            
        } else {
            singleAnsCombination.add(remained.get(right));
            n -= remained.get(right);
            k--;
            remained.remove(remained.get(right));
            return helper(remained, k, n, singleAnsCombination);
        }
    }
}
