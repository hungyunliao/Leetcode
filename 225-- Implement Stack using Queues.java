class MyStack {
    
    Queue<Integer> q = new LinkedList<Integer>();
    Queue<Integer> tempQ = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q.size() != 1) {
            tempQ.add(q.poll());
        }
        q.poll();
        while (tempQ.size() != 0) {
            q.add(tempQ.poll());
        }
    }

    // Get the top element.
    public int top() {
        while (q.size() != 1) {
            tempQ.add(q.poll());
        }
        int retVal = q.poll();
        while (tempQ.size() != 0) {
            q.add(tempQ.poll());
        }
        q.add(retVal);
        return retVal;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0? true : false;
    }
}
