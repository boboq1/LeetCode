package LeetCode.h0318克隆图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class Solution {
    //dfs
   /* public Node cloneGraph(Node node) {
        return helper(node,new HashMap<>());
    }
    private Node helper(Node node, HashMap<Integer,Node> map){
        if (node == null) return null;
        if (map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node newNode = new Node(node.val,new ArrayList<>());
        map.put(node.val,newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(helper(neighbor,map));
        }
        return newNode;
    }*/
    //bfs

}
