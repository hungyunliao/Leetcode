/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) { return 1; }
        return bSearch(1, n);
    }
    
    public int bSearch(int left, int right) {
        int mid = left/2 + right/2;
        if (isBadVersion(mid)) {
            if (!isBadVersion(mid - 1)) { return mid; }
            else { return bSearch(left, mid - 1); }
        }
        else {
            if (!isBadVersion(mid + 1)) { return bSearch(mid + 1, right); }
            else { return mid + 1; }
        }
    }
}
