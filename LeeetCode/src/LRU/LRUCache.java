package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexities for put and get operations: O(1)
 */
public class LRUCache {
    static class DLinkNode {
        int key, value;
        DLinkNode prev, next;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkNode() {

        }
    }

    DLinkNode tail, head;
    Map<Integer, DLinkNode> cache;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        // head will have value of 0. This value is never updated
        head = new DLinkNode();

        // tail will have value of 0. This value is never updated
        tail = new DLinkNode();

        // Initialize links of head and tail.
        head.next = tail;
        tail.prev = head;

        cache = new HashMap<>(capacity + 1);
    }

    public int get(int key) {
        if (cache.get(key) == null) return -1;
        DLinkNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        final DLinkNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {

            DLinkNode nodeToAdd = new DLinkNode(key, value);
            addNode(nodeToAdd);

            size++;
            cache.put(key, node);

            if (size < capacity) {
                final DLinkNode last = popLast();
                cache.remove(last.key);
                size--;
            }
        }
    }

    private void moveToHead(DLinkNode node) {
        remove(node);
        addNode(node);
    }

    private DLinkNode popLast() {
        final DLinkNode prev = tail.prev;
        remove(prev);
        return prev;
    }

    private void addNode(DLinkNode node) {
        node.prev = head;
        head.next.prev = node;

        node.next = head.next;
        head.next = node;
    }

    private void remove(DLinkNode node) {
        final DLinkNode prev = node.prev;
        final DLinkNode next = node.next;

        prev.next = next;
        next.prev = prev;

    }

}
