package serializeBinaryTree;

import nAryTree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Recursive dfs solution
     * Time and space complexity for both serialize and deserialize : O(n)
     */
    public static class Codec {
        private static final String emptySign = "X";
        private static final String delimiter = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return null;

            StringBuilder sb = new StringBuilder();
            serializePreorder(root, sb);

            return sb.substring(0, sb.length() - 1);
        }

        public void serializePreorder(TreeNode root, StringBuilder sb) {
            if (root == null) sb.append(emptySign).append(delimiter);
            else {
                sb.append(root.val).append(delimiter);
                serializePreorder(root.left, sb);
                serializePreorder(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) return null;
            LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(queue);
        }

        private TreeNode deserialize(LinkedList<String> queue) {
            if (queue.isEmpty()) return null;
            String nodeStr = queue.pollFirst();

            if (nodeStr.equals(emptySign)) return null;
            TreeNode subtreeRoot = new TreeNode(Integer.parseInt(nodeStr));
            subtreeRoot.left = deserialize(queue);
            subtreeRoot.right = deserialize(queue);
            return subtreeRoot;
        }
    }

    /**
     * Iterative DFS solution
     */

    public static class Codec1 {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            TreeNode x = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (x != null || !stack.isEmpty()) {
                if (x != null) {
                    sb.append(x.val);
                    sb.append(' ');
                    stack.push(x);
                    x = x.left;
                } else {
                    sb.append("null ");
                    x = stack.pop();
                    x = x.right;
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            String[] node = data.split(" ");
            int n = node.length;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(node[0]));
            TreeNode x = root;
            stack.push(x);

            int i = 1;
            while (i < n) {
                while (i < n && !node[i].equals("null")) {
                    x.left = new TreeNode(Integer.parseInt(node[i++]));
                    x = x.left;
                    stack.push(x);
                }
                while (i < n && node[i].equals("null")) {
                    x = stack.pop();
                    i++;
                }
                if (i < n) {
                    x.right = new TreeNode(Integer.parseInt(node[i++]));
                    x = x.right;
                    stack.push(x);
                }
            }
            return root;
        }
    }

    public static class Codec3 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            Queue<TreeNode> qu = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            qu.offer(root);
            sb.append(root.val);
            sb.append(' ');
            while (!qu.isEmpty()) {
                TreeNode x = qu.poll();
                if (x.left == null) sb.append("null ");
                else {
                    qu.offer(x.left);
                    sb.append(x.left.val);
                    sb.append(' ');
                }
                if (x.right == null) sb.append("null ");
                else {
                    qu.offer(x.right);
                    sb.append(x.right.val);
                    sb.append(' ');
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            String[] node = data.split(" ");
            Queue<TreeNode> qu = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(node[0]));
            qu.offer(root);
            int i = 1;
            while (!qu.isEmpty()) {
                Queue<TreeNode> nextQu = new LinkedList<>();
                while (!qu.isEmpty()) {
                    TreeNode x = qu.poll();
                    if (node[i].equals("null")) x.left = null;
                    else {
                        x.left = new TreeNode(Integer.parseInt(node[i]));
                        nextQu.offer(x.left);
                    }
                    i++;
                    if (node[i].equals("null")) x.right = null;
                    else {
                        x.right = new TreeNode(Integer.parseInt(node[i]));
                        nextQu.offer(x.right);
                    }
                    i++;
                }
                qu = nextQu;
            }
            return root;
        }
    }
}
