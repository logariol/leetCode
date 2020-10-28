package nAryTree.postorder;


import nAryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class Recursive {
    public List<Integer> postorder(Node root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        for (Node ch : root.children) {
            l.addAll(postorder(ch));

        }
        l.add(root.val);
        return l;
    }
}
