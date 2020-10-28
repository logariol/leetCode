package minumumWindoSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> targetCount = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int formed = 0;
        int needed = targetCount.size();
        int idxTo = 0;
        int idxFrom = 0;
        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};
        while (idxTo <= s.length() - 1) {
            char c = s.charAt(idxTo);
            counts.put(c, counts.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && counts.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }

            while (needed == formed && idxFrom <= idxTo) {
                c = s.charAt(idxFrom);
                // Save the smallest window until now.
                if (ans[0] == -1 || idxTo - idxFrom + 1 < ans[0]) {
                    ans[0] = idxTo - idxFrom + 1;
                    ans[1] = idxFrom;
                    ans[2] = idxTo;
                }

                counts.put(c, counts.get(c) - 1);
                if (targetCount.containsKey(c)) {
                    if (counts.get(c) < targetCount.get(c)) {
                        formed--;
                    }
                }
                idxFrom++;
            }
            idxTo++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.minWindow("bdab", "ab"));
//        System.out.println(s.minWindow("aa", "aa"));
//        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(s.minWindow("ABOABC", "ABC"));
//        System.out.println(s.minWindow("bbaa", "aba"));
        System.out.println(s.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
