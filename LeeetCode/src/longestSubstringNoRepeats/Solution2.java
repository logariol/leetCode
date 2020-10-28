package longestSubstringNoRepeats;

/**
 * Time complexity : O(min(m, n)^2) in worst case when all chars. Point is that unique chars are limited by O(min(n,m)) where m is the alphabet size
 * Space complexity : O(1). Only two integer variables used.
 * Approach. Find maximum length non repeating substring ending at each index in s.charArray;
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int longest = 0;
        int from = 0;

        for (int to = 1; to < s.length(); to++) {
            for (int idx = from; idx < to; idx++) {
                if (s.charAt(idx) == s.charAt(to)) {
                    // Repeating char found skip all positions till idx, since any char after to will contain duplicates in range [from, to]
                    from = idx + 1;
                    break;
                }
            }
            longest = Math.max(longest, to - from + 1);
        }
        return longest;
    }
}
