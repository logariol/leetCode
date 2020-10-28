package meetingRooms2;

import java.util.Arrays;

public class Solution3 {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for (int start : starts) {
            if (start < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}
