public class Solution {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        double v11 = 0, v22 = 0;
        int divide = 1;
        int x = 1;
        for (int i = version1.length() - 1; i > -1; i--) {
            if (version1.charAt(i) == '.') {
                divide = version1.length() - 1 - i;
                continue;
            }
            v11 += (version1.charAt(i) - '0') * x;
            x *= 10;
        }
        int versionNo1 = (int)(v11/Math.pow(10, divide));
        v11 = v11 - versionNo1 * Math.pow(10, divide);
        x = 1;
        
        for (int i = version2.length() - 1; i > -1; i--) {
            if (version2.charAt(i) == '.') {
                divide = version2.length() - 1 - i;
                continue;
            }
            v22 += (version2.charAt(i) - '0') * x;
            x *= 10;
        }
        int versionNo2 = (int)(v22/Math.pow(10, divide));
        v22 = v22 - versionNo2 * Math.pow(10, divide);
        
        // System.out.println(v11);
        // System.out.println(v22);
        
        if (versionNo1 > versionNo2) {
            return 1;
        } else if (versionNo1 < versionNo2) {
            return -1;
        } else return v11 > v22 ? 1 : (v11 == v22 ? 0 : -1);
    }
}
