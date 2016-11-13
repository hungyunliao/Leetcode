public class Solution {
    public int thirdMax(int[] nums) {
        int[] maxHeap = heapify(nums);
        int globalMax = maxHeap[1];
        if(nums.length < 3) return globalMax;
        
        int k = 0;
        int lastMaxValue = Integer.MIN_VALUE;
        while(k < 2) {
            
            if(maxHeap[1] != lastMaxValue) {
                lastMaxValue = maxHeap[1];
                k++;
            }
            maxHeap = deleteMax(maxHeap);
            
            if(maxHeap.length == 1) return globalMax;
        }
        
        while(maxHeap[1] == lastMaxValue) {
            maxHeap = deleteMax(maxHeap);
            if(maxHeap.length == 1) return globalMax;
        }
        
        return maxHeap[1];
    }
    
    public int[] deleteMax(int[] array) {
        if(array.length == 2) return new int[1];
        int max = array[1];
        
        int[] newArray = new int[array.length - 1];
        newArray[1] = array[array.length - 1];
        
        for(int i = 2; i < newArray.length; i++) newArray[i] = array[i];
        
        swap(newArray, 1);
        
        return newArray;
    }
    
    public int[] heapify(int[] array) {
        int leng = array.length;
        int[] maxHeap = new int[leng + 1];
        maxHeap[0] = 0;
        
        for(int i = 1; i <= leng; i++) maxHeap[i] = array[i - 1];
        for(int i = leng/2; i >= 1; i--) swap(maxHeap, i);
        
        return maxHeap;
    }
    
    public int[] swap(int[] array, int index) {
        int left = ((2 * index) < array.length)? 2 * index:index;
        int right = ((2 * index + 1) < array.length)? 2 * index + 1:index;
        
        int leftChild = array[left];
        int rightChild = array[right];
        
        if(Math.max(leftChild, rightChild) > array[index]) {
                int temp = array[index];
                if(leftChild >= rightChild) {
                    array[index] = array[left];
                    array[left] = temp;
                    return swap(array, left);
                } else {
                    array[index] = array[right];
                    array[right] = temp;
                    return swap(array, right);
                }
        }
        
        return array;
    }
}
