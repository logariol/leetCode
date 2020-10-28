package RemovedCoverdIntervals;

import java.util.Arrays;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o2[1], o1[1]);
        });

        int count = 0;
        int end, prev_end = 0;
        for (int[] curr : intervals) {
            end = curr[1];
            // if current interval is not covered
            // by the previous one
            if (prev_end < end) {
                ++count;
                prev_end = end;
            }
        }
        return count;
    }
}
