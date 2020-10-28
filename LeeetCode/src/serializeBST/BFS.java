package serializeBST;

import nAryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.poll();

            sb.append((char) (n.val));

            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        TreeNode root = new TreeNode(data.charAt(0));

        for (int i = 1; i < data.length(); i++) {
            add(root, data.charAt(i));
        }
        return root;
    }

    private void add(TreeNode root, int c) {
        TreeNode node = root;

        TreeNode prev = node;
        while (node != null) {
            if (c >= node.val) {
                node = node.right;
                if (node == null) {
                    prev.right = new TreeNode(c);
                } else {
                    prev = node;
                }
            } else {
                node = node.left;
                if (node == null) {
                    prev.left = new TreeNode(c);
                } else {
                    prev = node;
                }
            }
        }
    }
}
