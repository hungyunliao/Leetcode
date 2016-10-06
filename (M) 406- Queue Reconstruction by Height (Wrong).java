public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        int leng = people.length;
        int[][] heap = new int[leng + 1][people[0].length];
        int[][] ans = new int[leng][people[0].length];
        
        for(int i = 0; i < people.length; i++) {
            heap[i + 1] = people[i];
        }
        
        heap = heapify(heap);
        int x = 0;
        while(heap.length != 1) {
            heap = deleteMin(heap, ans, x);
            x++;
        }
        
        for(int i = 1; i < leng; i++) {
            int sumOfCurr = ans[i][0] + ans[i][1];
            int sumOfPrev = ans[i - 1][0] + ans[i - 1][1];
            if(sumOfCurr > sumOfPrev) {
                continue;
            } else {
                int quota = ans[i][1];
                for(int j = i - 1; j >= 0; j--) {
                    int heightOfPrev = ans[j][0];
                    int numbersOfPrev = ans[j][1];
                    if(heightOfPrev == ans[i][0]) {
                        quota -= (numbersOfPrev + 1);
                        if(quota < 0) {
                            // swap with prev
                            int[] temp = ans[i];
                            ans[i] = ans[i - 1];
                            ans[i - 1] = temp;
                        }
                        break;
                    } else if(heightOfPrev > ans[i][0]) {
                        quota -= 1;
                    }
                    if(quota < 0) {
                        // swap with prev
                        int[] temp = ans[i];
                        ans[i] = ans[i - 1];
                        ans[i - 1] = temp;
                    }
                }
                if (quota > 0 && i < leng - 1) {
                    // swap with next
                        int[] temp = ans[i];
                        ans[i] = ans[i + 1];
                        ans[i + 1] = temp;
                }
            }
        }
        
        
        
        return ans;
    }
    
    private int[][] heapify(int[][] heap) {
        int start = (heap.length%2 == 1)? heap.length/2:heap.length/2 - 1;
        if(heap.length == 3) {
            start = 1;
        }
        
        for(int i = start; i >= 1; i--) {
            int currIndex = i;
            
            int[] parent = heap[currIndex];
            int sumOfParent = parent[0] + parent[1];
            
            int[] leftChild = heap[2*currIndex];
            int sumOfLeftChild = leftChild[0] + leftChild[1];
            
            int[] rightChild = (start == 1 || 2*currIndex + 1 >= heap.length)? leftChild:heap[2*currIndex + 1];
            int sumOfRightChild = (start == 1 || 2*currIndex + 1 >= heap.length)? sumOfLeftChild:rightChild[0] + rightChild[1];
        
            int[] smallestChild = (sumOfLeftChild <= sumOfRightChild)? ((sumOfLeftChild == sumOfRightChild)? ((leftChild[1] < rightChild[1])? leftChild:rightChild): leftChild):rightChild;
            int sumOfSmallestChild = smallestChild[0] + smallestChild[1];
            int smallestChildIndex = (leftChild == smallestChild)? currIndex*2:currIndex*2 + 1;
            
            while(sumOfParent >= sumOfSmallestChild) {
                if (sumOfParent == sumOfSmallestChild && parent[1] <= smallestChild[1]) {
                    //no need to swap
                } else {
                    // swap
                    int[] temp = parent;
                    heap[currIndex] = heap[smallestChildIndex];
                    heap[smallestChildIndex] = temp;
                }
                
                currIndex = smallestChildIndex;
                parent = heap[currIndex];
                sumOfParent = parent[0] + parent[1];
                
                if(2*currIndex >= heap.length) {
                    break;
                }
                
                leftChild = heap[2*currIndex];
                sumOfLeftChild = leftChild[0] + leftChild[1];
                
                if(2*currIndex + 1 < heap.length) {
                    rightChild = heap[2*currIndex + 1];
                    sumOfRightChild = rightChild[0] + rightChild[1];
                } else {
                    rightChild = leftChild;
                    sumOfRightChild = sumOfLeftChild;
                }
                
                
                smallestChild = (sumOfLeftChild <= sumOfRightChild)? ((sumOfLeftChild == sumOfRightChild)? ((leftChild[1] < rightChild[1])? leftChild:rightChild): leftChild):rightChild;
                sumOfSmallestChild = smallestChild[0] + smallestChild[1];
                smallestChildIndex = (leftChild == smallestChild)? currIndex*2:currIndex*2 + 1;
            }
            
        }
        for(int i = 1; i < heap.length; i++) {
            System.out.print(heap[i][0] + " " + heap[i][1] + ", ");
        }
        System.out.println("");
        return heap;
    }
    
    private int[][] deleteMin(int[][] heap, int[][] ans, int index) {
        int[][] newHeap = new int[heap.length - 1][heap[0].length];
        for(int i = 1; i < newHeap.length; i++) {
            newHeap[i] = heap[i + 1];
        }
        
        ans[index] = heap[1];
        
        return heapify(newHeap);
    }
    
}
