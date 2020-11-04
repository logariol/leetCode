package binaryTreeMaxPathSum;

import nAryTree.TreeNode;

public class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int leftGain = Math.max(max_gain(node.left), 0);
        int rightGain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int sumAtRoot = node.val + leftGain + rightGain;

        // update max_sum if it's better to start a new path
        maxSum = Math.max(maxSum, sumAtRoot);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-5);
        node.left = new TreeNode(-1);
        node.right = new TreeNode(-1);
        Solution s = new Solution();
        System.out.println(s.max_gain(node));
    }
}
