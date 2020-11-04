package alienDict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    private final Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private final Map<Character, Boolean> seen = new HashMap<>();
    private final StringBuilder output = new StringBuilder();

    public String alienOrder(String[] words) {

        // Step 0: Put all unique letters into reverseAdjList as keys.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            int minWordsLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minWordsLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        // Step 2: DFS to build up the output list.
        for (Character c : reverseAdjList.keySet()) {
            boolean result = dfs(c);
            if (!result) return "";
        }


        if (output.length() < reverseAdjList.size()) {
            return "";
        }
        return output.toString();
    }

    // Return true iff no cycles detected.
    private boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            return seen.get(c); // If this node was grey (false), a cycle was detected.
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.alienOrder(new String[]{"wrt",
//                "wrf",
//                "er",
//                "ett",
//                "rftt"}));

        System.out.println(s.alienOrder(new String[]{"z",
                "z"}));


//        System.out.println(s.alienOrder(new String[]{"z",
//                "x",
//                "z",
//                "ett",
//                "rftt"
//        }));
    }
}
