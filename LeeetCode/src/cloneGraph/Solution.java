package cloneGraph;

import java.util.*;

public class Solution {
    static class Node {
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

    static final Map<Node, Node> oldeToNew = new HashMap<>();

    /**
     * Time complexity : O(n + m) where n is the number of nodes and m is the number of edges. At most m = 2n.
     * Space comlexity : O(n) to keep cache and O(h) for recurstion. h - is the heights of the graph
     * @param node
     * @return
     */
    public Node cloneGraphDFS(Node node) {
        if (node == null) {
            return node;
        }
        if (oldeToNew.get(node) != null) return oldeToNew.get(node);

        Node newNode = new Node(node.val, new ArrayList<>());
        oldeToNew.put(node, newNode);

        for (Node neigh : node.neighbors) {
            newNode.neighbors.add(cloneGraphDFS(neigh));
        }

        return newNode;
    }
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
    */

    /**
     * Time complexity : O(n + m) where n is the number of nodes and m is the number of edges. At most m = 2n.
     * Space comlexity : O(n) to keep cache and O(W) for recurstion. W - is the width of the graph
     * @param node
     * @return
     */
    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return node;
        }

        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap<>();

        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            Node n = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }

}
