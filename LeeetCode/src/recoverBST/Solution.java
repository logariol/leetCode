package recoverBST;

import nAryTree.TreeNode;

public class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        swap(first, second);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inOrder(root.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
////        root.right = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(2);

        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(0);

        Solution s = new Solution();
        s.recoverTree(root);
    }
}
