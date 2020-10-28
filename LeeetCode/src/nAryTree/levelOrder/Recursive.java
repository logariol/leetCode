package nAryTree.levelOrder;

import nAryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class Recursive {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        traverse(root, 0);
        return result;
    }

    private void traverse(Node node, int level) {
        if (result.size() <= level) result.add(new ArrayList<>());
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverse(child, level + 1);
        }
    }
}
