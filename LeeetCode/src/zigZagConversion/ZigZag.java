package zigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        List<StringBuilder> k = new ArrayList<>();

        boolean up = true;
        int idx = 0;

        int mainStrIdx = 0;
        while (mainStrIdx < s.length()) {
            while (up && mainStrIdx < s.length()) {
                if (idx < numRows - 1) {
                    if (k.size() < idx + 1) k.add(new StringBuilder());

                    k.get(idx).append(s.charAt(mainStrIdx++));
                    idx++;
                } else {
                    up = false;
                }
            }
            while (!up && mainStrIdx < s.length()) {
                if (idx > 0) {
                    if (k.size() < idx + 1) k.add(new StringBuilder());
                    k.get(idx).append(s.charAt(mainStrIdx++));
                    idx--;
                } else {
                    up = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder str : k) {
            sb.append(str);
        }

        return sb.toString();
    }
}
