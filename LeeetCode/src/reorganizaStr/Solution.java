package reorganizaStr;

public class Solution {
    /*
    Time complexity : O(n)
    Space complexity : O(n);
     */
    public String reorganizeString(String s) {
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }

        int max = 0, letter = 0;
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] > max) {
                max = cnts[i];
                letter = i;
            }
        }
        if (max > (s.length() + 1) / 2) return "";

        int idx = 0;
        char[] res = new char[s.length()];
        while (cnts[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            cnts[letter]--;
        }


        for (int i = 0; i < cnts.length; i++) {
            while (cnts[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                cnts[i]--;
            }
        }
        return String.valueOf(res);

    }


}
