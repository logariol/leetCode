package longestSubstringNoRepeats;


import java.util.HashMap;
import java.util.Map;

/**
 * Time : O(n)
 * Space : O(1)
 * <p>
 * Approach. Keep track of when is the last time char was seen
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, longest = 0;

        // abba
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start)
                    start = map.get(c) + 1;
            }
            longest = Math.max(longest, i - start + 1);
            map.put(c, i);
        }

        return longest;
    }
}
