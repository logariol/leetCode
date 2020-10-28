package copyListRandomPointer;

import java.util.HashMap;

public class Iterative {
    /**
     * Time and space complexities : O(N);
     */
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    private Node getClonedNode(Node node) {
        if (node == null) return null;

        if (visitedHash.containsKey(node)) return visitedHash.get(node);
        else {
            visitedHash.put(node, new Node(node.val, null, null));
            return visitedHash.get(node);
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node oldNode = head;

        Node newNode = new Node(oldNode.val, null, null);
        visitedHash.put(oldNode, newNode);

        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visitedHash.get(head);
    }
}
