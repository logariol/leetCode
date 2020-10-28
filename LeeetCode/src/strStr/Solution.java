package strStr;

public class Solution {


    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        int idx1 = 0;
        int pos = -1;

        while (idx1 < haystack.length()) {
            while (idx1 < haystack.length() &&
                    haystack.charAt(idx1) != needle.charAt(0)) {
                idx1++;
            }

            if (idx1 + needle.length() <= haystack.length() && haystack.substring(idx1, idx1 + needle.length()).equals(needle))
                return idx1;
            else idx1++;
        }
        return pos;
    }

}
