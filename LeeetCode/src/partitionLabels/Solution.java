package partitionLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity : O(2N) = O(N)
 * Space complexity : O(1). Output list size is from 1 to 26;
 */
public class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];

        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int next = 0;
        int j = 0;
        List<Integer> ret = new ArrayList<>();


        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, last[S.charAt(i) - 'a']);

            if (j == i) {
                ret.add(i - next + 1);
                next = i + 1;
            }
        }
        return ret;
    }

}
