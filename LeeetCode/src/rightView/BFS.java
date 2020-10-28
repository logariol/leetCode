package rightView;

import nAryTree.TreeNode;

import java.util.*;

public class BFS {
    /*
        Time complexity:  O(N) since one has to visit each node.

        Space complexity: O(D) to keep the queues, where D is a tree diameter.
        Let's use the last level to estimate the queue size.
        This level could contain up to N/2 tree nodes in the case of complete binary tree.
     */
    static class TwoQueue {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> answer = new ArrayList<>();
            ArrayDeque<TreeNode> curr;
            ArrayDeque<TreeNode> next = new ArrayDeque<>() {{
                offer(root);
            }};

            TreeNode node = null;
            while (!next.isEmpty()) {
                curr = next.clone();
                next.clear();

                while (!curr.isEmpty()) {
                    node = curr.poll();

                    if (node.left != null) {
                        next.add(node.left);
                    }
                    if (node.right != null) {
                        next.add(node.right);
                    }
                }

                if (curr.isEmpty()) answer.add(node.val);
            }
            return answer;
        }
    }

    static class QueueSentinel {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> answer = new ArrayList<>();
            Queue<TreeNode> deque = new LinkedList<>() {{
                offer(root);
                offer(null);
            }};

            TreeNode prev, curr = root;

            while (!deque.isEmpty()) {
                prev = curr;
                curr = deque.poll();

                while (curr != null) {
                    if (curr.left != null) deque.offer(curr.left);
                    if (curr.right != null) deque.offer(curr.right);
                    prev = curr;
                    curr = deque.poll();
                }

                answer.add(prev.val);
                if (!deque.isEmpty()) {
                    deque.offer(null);
                }
            }
            return answer;
        }
    }

    static class QueueLevelLength {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return new ArrayList<Integer>();

            ArrayDeque<TreeNode> queue = new ArrayDeque() {{
                offer(root);
            }};
            List<Integer> rightside = new ArrayList<>();

            while (!queue.isEmpty()) {
                int levelLength = queue.size();

                for (int i = 0; i < levelLength; ++i) {
                    TreeNode node = queue.poll();
                    // if it's the rightmost element
                    if (i == levelLength - 1) {
                        rightside.add(node.val);
                    }

                    // add child nodes in the queue
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return rightside;
        }
    }
}
