package copyListRandomPointer;

public class Node {
    Node next;
    Node random;
    int val;

    public Node(int val, Node next, Node random) {
        this.next = next;
        this.random = random;
        this.val = val;
    }
}
