package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] array) {
        List<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0 || array[0].length == 0) return list;

        int rStart = 0;
        int rEnd = array.length - 1;
        int cStart = 0;
        int cEnd = array[0].length - 1;

        while (rStart <= rEnd && cStart <= cEnd) {
            for (int col = cStart; col <= cEnd; col++) {
                list.add(array[rStart][col]);
            }

            for (int row = rStart + 1; row <= rEnd; row++) {
                list.add(array[row][cEnd]);
            }

            for (int col = cEnd - 1; col >= cStart; col--) {
                if (rStart == rEnd) break;
                list.add(array[rEnd][col]);
            }

            for (int row = rEnd - 1; row > rStart; row--) {
                if (cStart == cEnd) break;
                list.add(array[row][cStart]);
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }

        return list;
    }
}
