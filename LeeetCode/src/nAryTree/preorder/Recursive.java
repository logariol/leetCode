package nAryTree.preorder;

import nAryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class Recursive {
    public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<>();

        if (root == null) return l;
        l.add(root.val);
        for (Node ch : root.children) {
            l.addAll(preorder(ch));
        }

        return l;
    }
}
