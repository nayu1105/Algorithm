/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>(); 

    public Node cloneGraph(Node node) {

        if(node==null) return null;

        dfs(node);

        return map.get(1);
    }

    public void dfs(Node node){
        if(node.neighbors==null)return;
        map.put(node.val, new Node(node.val));
        Node currNode = map.get(node.val);        
        for(int i=0; i<node.neighbors.size(); i++){
            if(!map.containsKey(node.neighbors.get(i).val)){
                dfs(node.neighbors.get(i));
            }
            currNode.neighbors.add(map.get(node.neighbors.get(i).val));
        }
    }
}