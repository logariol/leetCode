package serializeBST;

import nAryTree.TreeNode;

public class Fastest {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        //char[] chars = new char[2];
        //char[0] = (char)((value & 0xffff))
        //char[1] = (char)((value >> 16) & 0xffff)
        sb.append((char) (root.val));
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        return deserialize(data, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode deserialize(String data, int min, int max) {
        if (index == data.length()) return null;
        int x = data.charAt(index);
        if (x < min || x > max) return null;
        index++;
        TreeNode node = new TreeNode(x);
        node.left = deserialize(data, min, x);
        node.right = deserialize(data, x, max);
        return node;
    }
}
