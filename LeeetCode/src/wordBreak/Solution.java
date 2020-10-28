package wordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
    static class DPSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict == null || wordDict.isEmpty()) return false;
            // For quick search
            HashSet<String> set = new HashSet<>(wordDict);
            //
            /*
                DP state - for each [index], can we segment a substring from [0, [index]] using words in dictionary.
                Example 1:
                Trace:
                    wordDict = [leet, code]. Length 8;
                    s = "leetcode"
                    Initial state
                    ind [0, 1, 2, 3, 4, 5, 6, 7, 8]
                    dp  [t, f, f, f, f, f, f, f, f]

                    After processing "leet". Substring with [0, 3] -> dp[1, 4]
                    ind [0, 1, 2, 3, 4, 5, 6, 7, 8]
                    dp  [t, f, f, f, t, f, f, f, f]

                    After processing "code". Substring with [4, 7] -> dp[5, 8]
                    ind [0, 1, 2, 3, 4, 5, 6, 7, 8]
                    dp  [t, f, f, f, t, f, f, f, t]

                Example 2:
                wordDict = [aaaa, aaa]. Length 7;
                s = "aaaaaaa"
                Initial state
                ind [0, 1, 2, 3, 4, 5, 6, 7]
                dp  [t, f, f, f, f, f, f, f]
                Trace:
                    After processing "aaa". Substring with [0, 2] -> dp[1, 3]. aaa
                    ind [0, 1, 2, 3, 4, 5, 6, 7]
                    dp  [t, f, f, t, f, f, f, f]

                    After processing "aaaa". Substring with [0, 3] -> dp[1, 4]. aaaa
                    ind [0, 1, 2, 3, 4, 5, 6, 7]
                    dp  [t, f, f, t, t, f, f, f]

                    After processing "aaaaaa". Substring with [0, 5] -> dp[1, 6]. aaa + aaa
                    ind [0, 1, 2, 3, 4, 5, 6, 7]
                    dp  [t, f, f, t, t, f, t, f]

                    After processing "aaaaaaa". Substring with [0, 6] -> dp[1, 7]. aaaa + aaa
                    ind [0, 1, 2, 3, 4, 5, 6, 7]
                    dp  [t, f, f, t, t, f, t, t]

            Time complexity : O(N^2) for two nested for loops and o(n) for substring. O(N^3)
            Space complexity : O(N) to store dp array
             */
            boolean[] dp = new boolean[s.length() + 1];
            // Substring "" can be segmented for sure
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    // dp[j] means we can segment [0, j). So if dictionary contains substring[j, i) then we can segment [0, i); Transitive.
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        // Why break?
                        // Because substring [j, i) may include some other smaller segmentations, but right now we already know the one possible segment, we can skip others
                        dp[i] = true;
                        break;
                    }
                }
            }
            // Can we segment the whole string?
            return dp[s.length()];
        }


    }

    static class TrieSolution {
        // Basic trie node. Nothing special
        static class TrieNode {
            boolean isWord;
            Map<Character, TrieNode> children;

            public TrieNode() {
                isWord = false;
                children = new HashMap<>();
            }
        }

        // Basic word add.
        public void addWord(TrieNode node, String word) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
        }


        public boolean wordBreak(String s, List<String> wordDict) {
            /*
               Add dictionary words to trie
               Search for segments

                Time complexity : O(N^2) for two nested for loops.
                Space complexity : O(N) to store dp array and trie
             */
            TrieNode root = new TrieNode();
            for (String w : wordDict) {
                addWord(root, w);
            }
            int len = s.length();
            // Still need this.
            boolean[] dp = new boolean[len + 1];
            dp[len] = true;

            for (int i = len - 1; i >= 0; i--) {

                TrieNode searchNode = root;

                for (int j = i; j < len && searchNode != null; j++) {
                    // Search for substring [i, j) in a trie. If there is such a word, then we can segment [i, j), so set dp[i] to true
                    char c = s.charAt(j);
                    searchNode = searchNode.children.get(c);
                    if (searchNode != null && dp[j + 1] && searchNode.isWord) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            // Can we segment [0, len]?
            return dp[0];
        }
    }
}
