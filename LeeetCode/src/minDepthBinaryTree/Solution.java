package minDepthBinaryTree;

import nAryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return getDepths(root, 0);
    }

    private int getDepths(TreeNode node, int running) {
        if (node == null) return Integer.MAX_VALUE;
        int levelDepth = running + 1;
        if (node.left == null && node.right == null) return levelDepth;
        else return Math.min(getDepths(node.left, levelDepth), getDepths(node.right, levelDepth));
    }

    public int minDepthIter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);

        int level = 0;
        while (!q1.isEmpty()) {
            int size = q1.size();
            level++;
            while (size-- > 0) {

                TreeNode c = q1.poll();

                if (c.left == null && c.right == null) {
                    return level;
                }
                if (c.left != null) {
                    q1.add(c.left);
                }
                if (c.right != null) {
                    q1.add(c.right);
                }
            }
        }
        return level;
    }
}
