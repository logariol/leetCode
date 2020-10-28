package longestPalindromicSubstring;

/**
 Space complexity : O(1)
 Time complexity : worst case O(n^2)
 */
public class Solution {
    int startIndex = 0;
    int endIndex = 0;

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) return "";

        int startIdx = 0;
        while (startIdx < s.length()) {
            startIdx = expand(s, startIdx);
        }

        return s.substring(startIndex, endIndex);
    }

    private int expand(String s, int startIdx) {
        int nextIdx = startIdx + 1;

        while (nextIdx < s.length() && s.charAt(nextIdx) == s.charAt(startIdx)) {
            nextIdx++;
        }

        int endIdx = nextIdx - 1;

        while (endIdx + 1 < s.length() && startIdx > 0 && s.charAt(startIdx - 1) == s.charAt(endIdx + 1)) {
            startIdx--;
            endIdx++;
        }

        if ((endIndex - startIndex) < (endIdx - startIdx)) {
            endIndex = endIdx;
            startIndex = startIdx;
        }
        return nextIdx;
    }
}
