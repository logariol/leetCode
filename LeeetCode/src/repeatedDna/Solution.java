package repeatedDna;

import java.util.*;

public class Solution {
    static class TrieSolution {
        static class TrieNode {
            Map<Character, TrieNode> children;
            boolean isValid;
            int cnt;

            public TrieNode() {
                children = new HashMap<>();
            }
        }

        public List<String> findRepeatedDnaSequences(String s) {
            if (s == null || s.isEmpty()) return new ArrayList<>();

            HashSet<String> repeatedSeqs = new HashSet<>();
            TrieNode root = new TrieNode();
            for (int i = 0; i <= s.length() - 10; i++) {
                addToTrie(root, repeatedSeqs, s.substring(i, i + 10));
            }

            return new ArrayList<>(repeatedSeqs);
        }

        private void addToTrie(TrieNode root, HashSet<String> repeatedSeqs, String substring) {
            for (int i = 0; i < substring.length(); i++) {
                if (!root.children.containsKey(substring.charAt(i))) {
                    root.children.put(substring.charAt(i), new TrieNode());
                }
                root = root.children.get(substring.charAt(i));
            }
            root.isValid = true;
            root.cnt++;
            if (root.cnt > 1) repeatedSeqs.add(substring);
        }
    }

    static class SlidingWindow {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s == null || s.isEmpty()) return new ArrayList<>();

            int L = 10, n = s.length();
            HashSet<String> seen = new HashSet<>();
            HashSet<String> output = new HashSet<>();
            for (int i = 0; i < n - L + 1; i++) {
                String sub = s.substring(i, i + L);
                if (seen.contains(sub)) output.add(sub);
                else seen.add(sub);
            }
            return new ArrayList<>(output);
        }
    }

    public static void main(String[] args) {

    }


}
