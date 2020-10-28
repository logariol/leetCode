package buildTreeInorderPostorder;

import nAryTree.TreeNode;

import java.util.HashMap;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> inOrderPos = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            inOrderPos.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, inOrderPos);
    }

    private TreeNode buildTreePostIn(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int rootIdx,
                                     HashMap<Integer, Integer> inOrderPos) {
        if (postorderStart > rootIdx || inorderStart > inorderEnd) return null;
        int rootVal = postorder[rootIdx];
        TreeNode root = new TreeNode(rootVal);
        int ri = inOrderPos.get(rootVal);

        int leftSubTreeRoot = postorderStart + ri - inorderStart - 1;
        int rightSubTreeRoot = postorderStart + ri - inorderStart;

        root.left = buildTreePostIn(inorder, inorderStart, ri - 1, postorder, postorderStart, leftSubTreeRoot, inOrderPos);
        root.right = buildTreePostIn(inorder, ri + 1, inorderEnd, postorder, rightSubTreeRoot, rootIdx - 1, inOrderPos);
        return root;
    }
}
