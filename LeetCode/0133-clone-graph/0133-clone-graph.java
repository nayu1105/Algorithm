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

    public Node cloneGraph(Node node) {
        if(node == null)
		 return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        map.put(node, new Node(node.val));
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            Node cloneNode = map.get(currNode);

            for(Node temp : currNode.neighbors){
                if(!map.containsKey(temp)){
                    map.put(temp, new Node(temp.val));
                    queue.add(temp);
                }
                cloneNode.neighbors.add(map.get(temp));
            }
        }

        return map.get(node);
    }
}