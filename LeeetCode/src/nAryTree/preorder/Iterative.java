package nAryTree.preorder;

import nAryTree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Iterative {
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            final Node p = stack.pop();

            output.add(p.val);
            for (int i = p.children.size() - 1; i >= 0; i--) {
                stack.push(p.children.get(i));
            }

        }
        return output;
    }
}
