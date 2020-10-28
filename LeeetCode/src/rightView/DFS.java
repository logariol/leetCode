package rightView;

import nAryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    /*
    Space : o(H), H = N in worst case
    Time : o(N) where N is node count
     */
    List<Integer> rightside = new ArrayList();

    private void dfs(TreeNode n, int level) {
        if (level == rightside.size()) {
            rightside.add(n.val);
        }
        if (n.right != null) {
            dfs(n.right, level + 1);
        }
        if (n.left != null) {
            dfs(n.left, level + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;

        dfs(root, 0);
        return rightside;
    }
}
