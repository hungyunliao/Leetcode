public class Solution {
    public int arrangeCoins(int n) {
        if(n == 0) {
            return 0;
        }
        int layer = 1, maxLayer = 0;
        while(true) {
            double sum = (1 + layer) / 2.0 * layer;
            if(sum < n) {
                if(maxLayer == 0) {
                    layer *= 2;
                } else {
                    layer = bSearch(layer, maxLayer, n);
                    break;
                }
            } else if(sum > n) {
                maxLayer = layer;
                layer /= 2;
            } else {
                break;
            }
        }
        return layer;
    }
    
    private int bSearch(int layer, int maxLayer, int n) {
        if(layer + 1 == maxLayer) {
            return layer;
        }
        int midLayer = (layer + maxLayer) / 2;
        double sum = (midLayer + 1) / 2.0 * midLayer;
        if(sum < n) {
            return bSearch(midLayer, maxLayer, n);
        } else if(sum > n) {
            return bSearch(layer, midLayer, n);
        } else {
            return midLayer;
        }
    }
}
