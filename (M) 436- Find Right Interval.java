/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        
        int[] ans = new int[intervals.length];
        List<Interval> start = new ArrayList<Interval>();
        Map<Interval, Integer> index = new HashMap<>();
        
        if(intervals.length == 0) return ans;
        else if(intervals.length == 1) {
            ans[0] = -1;
            return ans;
        }
        
        for(int i = 0; i < ans.length; i++) ans[i] = -2;
        
        for(int i = 0; i < intervals.length; i++) {
            start.add(intervals[i]);
            index.put(intervals[i], i);
        }
        
        // sorting by the start time. Set the finish time as the target, and use binary search to find the interval with the start time that matches the finish time.
        // The last one must always be -1 since there is no interval starting after it.
        Collections.sort(start, new StartTimeComparator());
        
        for(int i = 0; i < intervals.length - 1; i++) {
            int target = start.get(i).end;
            Interval obj = bSearch(start, i + 1, intervals.length - 1, target);
            if(obj == null) continue;
            ans[index.get(start.get(i))] = index.get(obj);
        }
        
        for(int i = 0; i < ans.length; i++) if(ans[i] == -2) ans[i] = -1;
        
        return ans;
    }
    
    public Interval bSearch(List<Interval> list, int left, int right, int target) {
        if(left >= right) {
            if(list.get(left).start < target) return null;
            else return list.get(left);
        }
    
        int mid = (left + right) / 2;
        
        if(list.get(mid).start == target) return list.get(mid);
        else if(list.get(mid).start > target) return bSearch(list, left, mid - 1, target);
        else return bSearch(list, mid + 1, right, target);
        
    }
}

// Implement comparator to compare the object
class StartTimeComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
}
