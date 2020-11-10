package wordBreak2;

import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict));
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<Integer>[] starts = new List[s.length() + 1]; // valid start positions
        starts[0] = new ArrayList<>();

        int maxLen = getMaxLen(wordDict);
        for (int endPos = 1; endPos <= s.length(); endPos++) {
            for (int startPos = endPos - 1; startPos >= endPos - maxLen && startPos >= 0; startPos--) {
                if (starts[startPos] == null) continue;
                String word = s.substring(startPos, endPos);
                if (wordDict.contains(word)) {
                    if (starts[endPos] == null) {
                        starts[endPos] = new ArrayList<>();
                    }
                    starts[endPos].add(startPos);
                }
            }
        }

        List<String> rst = new ArrayList<>();
        if (starts[s.length()] == null) {
            return rst;
        }

        dfs(rst, "", s, starts, s.length());
        return rst;
    }


    private void dfs(List<String> rst, String path, String s, List<Integer>[] starts, int end) {
        if (end == 0) {
            rst.add(path.substring(1));
            return;
        }

        for (Integer start : starts[end]) {
            String word = s.substring(start, end);
            dfs(rst, " ".concat(word).concat(path), s, starts, start);
        }
    }

    private int getMaxLen(Set<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            max = Math.max(max, s.length());
        }
        return max;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
//        System.out.println(s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
//        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

//        System.out.println(s.wordBreak("aaaaaaa",
//                Arrays.asList("aaaa", "aa", "a")));

        System.out.println(s.wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

        /*
"catsandog"
["cats","dog","sand","and","cat"]



         */
    }

}
