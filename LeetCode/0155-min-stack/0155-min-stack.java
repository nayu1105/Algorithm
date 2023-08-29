class MinStack {

    Node head;

    public MinStack() {
       head = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        head = new Node(val, head.min < val ? head.min : val, head);
    }
    
    public void pop() {
        head = head.pre;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    class Node{
        int val;
        int min;
        Node pre;

        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node pre){
            this.val = val;
            this.min = min;
            this.pre = pre;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */