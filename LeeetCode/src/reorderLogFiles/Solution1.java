package reorderLogFiles;

import java.util.Arrays;

public class Solution1 {

    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return logs;

        int nums = 0;
        for (int i = logs.length - 1; i >= 0; i--) {
            // Move number to the end in order
            if (Character.isDigit(logs[i].charAt(logs[i].indexOf(" ") + 1))) {
                swap(logs, i, logs.length - 1 - nums);
                nums++;
            }
        }

        // Sort the non-number part in the front
        Arrays.sort(logs, 0, logs.length - nums,
                (a, b) -> {
                    String a1 = a.substring(a.indexOf(" ") + 1);
                    String b1 = b.substring(b.indexOf(" ") + 1);
                    int i = a1.compareTo(b1);
                    if (i != 0) return i;
                    else return a.compareTo(b);
                });

        return logs;
    }

    private void swap(String[] logs, int a, int b) {
        String t = logs[a];
        logs[a] = logs[b];
        logs[b] = t;
    }
}
