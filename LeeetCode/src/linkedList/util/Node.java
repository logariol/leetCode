package linkedList.util;


/**
 * Singly linked list node
 */
public class Node {
    final int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
    }
}
