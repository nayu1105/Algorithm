import java.util.*;

class MinStack {

    private Stack<Node> stack;  

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.size() == 0){stack.push(new Node(val, val));}
        else{
            stack.push(new Node(val, val < stack.peek().min ? val : stack.peek().min));
        }        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }

    class Node{
        int val;
        int min;

        public Node(int val, int min){
            this.val = val;
            this. min = min;
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