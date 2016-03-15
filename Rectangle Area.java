public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return Area(A,B,C,D)+Area(E,F,G,H) - intersect(A,C,E,G)*intersect(B,D,F,H);
    }
    public int Area(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }
    public int intersect(int a1, int a2, int b1, int b2) {
        if (b2 <= a1 || b1 >= a2) return 0;
        else if (b1 <= a1 && b2 >= a2) return a2 - a1; 
        else if (b1 >= a1 && b2 <= a2) return b2 - b1;
        else if (b1 >= a1 && b1 <= a2) return a2 - b1;
        else if (b2 >= a1 && b2 <= a2) return b2 - a1;
        else return 0;
    }
}
