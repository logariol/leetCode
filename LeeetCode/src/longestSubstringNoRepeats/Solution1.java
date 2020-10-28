package longestSubstringNoRepeats;

import java.util.HashSet;

/**
 * Time complexity : O(2n) = O(n).
 * Space complexity : O(min((m, n)). m is is th alphabet size, n is the input size.
 * Approach. Make a sliding window of unique chars.
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int longest = 0;

        int from = 0, to = 0;
        while (from < s.length() && to < s.length()) {
            if (!set.contains(s.charAt(to))) {
                set.remove(s.charAt(to++));
                longest = Math.max(longest, to - from);
            } else {
                set.remove(s.charAt(from++));
            }

        }
        return longest;
    }
}
