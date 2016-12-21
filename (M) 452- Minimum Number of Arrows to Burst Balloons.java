public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1) {
            return (points.length == 0)? 0 : 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(Integer.valueOf(o1[0]).equals(o2[0])) {
                    return Integer.valueOf(o1[1]).compareTo(o2[1]);
                }
                return Integer.valueOf(o1[0]).compareTo(o2[0]);
            }
        });
        int baseIndex = 0, ans = 0;
        int[] range = points[0];
        while(baseIndex < points.length - 1) {
            for(int i = baseIndex + 1; i < points.length; i++) {
                range = overlpRange(range, points[i]);
                if(range[0] > range[1]) {
                    ans += 1;
                    baseIndex = i;
                    if(baseIndex == points.length - 1) {
                         ans++;
                    }
                    range = points[baseIndex];
                    break;
                } else if(i == points.length - 1) {
                    ans += 1;
                    baseIndex = i;
                    break;
                }
            }
        }
        return ans;
    }
    
    private boolean isOverlapped(int[] A, int[] B) {
        if(A[1] < B[0] || A[0] > B[1]) {
            return false;
        }
        return true;
    }
    
    private int[] overlpRange(int[] range, int[] B) {
        if(!isOverlapped(range, B)) {
            range[0] = 1;
            range[1] = 0;
            return range;
        } else {
            range[0] = Math.max(range[0], B[0]);
            range[1] = Math.min(range[1], B[1]);
            return range;
        }
    }
}
