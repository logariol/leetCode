package countOfSmallerNumbers;

import java.util.Arrays;
import java.util.List;

public class Solution {
    static class BST {
        static class Node {
            Node left, right;
            int val, cnt, dup = 1;

            public Node(int v, int s) {
                val = v;
                cnt = s;
            }
        }

        public static List<Integer> countSmaller(int[] nums) {
            Integer[] ans = new Integer[nums.length];
            Node root = null;
            for (int i = nums.length - 1; i >= 0; i--) {
                root = insert(nums[i], root, ans, i, 0);
            }
            return Arrays.asList(ans);
        }

        private static Node insert(int num, Node node, Integer[] ans, int i, int preCnt) {
            if (node == null) {
                node = new Node(num, 0);
                ans[i] = preCnt;
            } else if (node.val == num) {
                node.dup++;
                ans[i] = preCnt + node.cnt;
            } else if (node.val > num) {
                node.cnt++;
                node.left = insert(num, node.left, ans, i, preCnt);
            } else {
                node.right = insert(num, node.right, ans, i, preCnt + node.dup + node.cnt);
            }
            return node;
        }

        public static void main(String[] args) {
            BST.countSmaller(new int[]{3, 2, 2, 6, 1});
        }
    }
}
