package mergeIntervals;

public class Solution {
    /*
      Case 1
    [1, 7], [1,4] -> [1, 7];
    Case 2
    [1, 7], [0, 4] -> [0, 7];

    Case 3
    [0, 8], [1, 3] -> [0, 8]

    Non overlapping case :
    [1, 3], [4, 5]. More more

     */
    public int[][] merge(int[][] intervals) {
        int count = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] s1 = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] s2 = intervals[j];
                if (s1[1] >= s2[0] && s2[1] >= s1[0]) {
                    s2[0] = Math.min(s1[0], s2[0]);
                    s2[1] = Math.max(s1[1], s2[1]);
                    s1[0] = 1;
                    s1[1] = 0;
                    count--;
                    break;
                }
            }
        }
        int[][] arr = new int[count][];
        int k = 0;
        for (int[] interval : intervals) {
            if (interval[0] <= interval[1]) {
                arr[k++] = interval;
            }
        }
        return arr;
    }
}
