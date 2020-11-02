package meetingRooms;

import java.util.Arrays;

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        int n = intervals.length;
        int[] ends = new int[n];
        int[] starts = new int[n];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int startIdx = 0;
        int endIdx = 0;

        while (startIdx < n && endIdx < n) {
            if (startIdx == endIdx) {
                if (starts[startIdx] <= ends[endIdx]) {
                    startIdx++;
                }
            } else if (starts[startIdx] < ends[endIdx]) {
                return false;
            } else if (starts[startIdx] >= ends[endIdx]) {
                endIdx++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
