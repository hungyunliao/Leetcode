public class MinStack {
    
    private Map<Integer, int[]> map;
    private int min;
    private int index;
    
    /** initialize your data structure here. */
    public MinStack() {
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
        index = 0;
    }
    
    public void push(int x) {
        
        map.put(index, new int[] {min, x});
        if (x < min) {
            min = x;
        }
        index++;
    }
    
    public void pop() {
        
        map.remove(index-1);
        index--;
        
        if (index == 0) {
            min = Integer.MAX_VALUE;
        } else {
            min = Math.min(map.get(index-1)[0], map.get(index-1)[1]);
        }
        
    }
    
    public int top() {
        return map.get(index-1)[1];
    }
    
    public int getMin() {
        return Math.min(map.get(index-1)[0], map.get(index-1)[1]);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
