package LeetCode.h0318克隆图;

import java.util.*;

/*class Node {
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
}*/

public class Solution2 {
//bfs
   /* public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Integer,Node> visited = new HashMap<>();
        visited.put(node.val,new Node(node.val,new ArrayList<>()));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);
        Node newNode = null;
        while (!nodeQueue.isEmpty()) {
            newNode = nodeQueue.poll();
            for (Node neighbor : newNode.neighbors) {
                if (visited.containsKey(neighbor.val)) {
                    visited.get(newNode.val).neighbors.add(visited.get(neighbor.val));
                } else {
                    Node node1 = new Node(neighbor.val,new ArrayList<>());
                    visited.put(neighbor.val,node1);
                    visited.get(newNode.val).neighbors.add(visited.get(neighbor.val));
                    nodeQueue.add(neighbor);
                }
            }
        }
        return newNode;
    }*/
    //dfs
   public Node cloneGraph(Node node) {
       if (node == null)return node;
       Map<Integer,Node> visited = new HashMap<>();
       return clone(node,visited);
   }

    private Node clone(Node node,Map<Integer,Node> visited) {
       if (node == null) return null;
       if (visited.containsKey(node.val)) return visited.get(node.val);
       Node cur = new Node(node.val,new ArrayList<>());
       visited.put(node.val, cur);
        for (Node neighbor : node.neighbors) {
            cur.neighbors.add(clone(neighbor,visited));
        }
        return cur;
    }


}
