package maximumDistanceInArray;

import java.util.List;

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() == 0) return 0;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        int result = Integer.MIN_VALUE;


        for (int i = 1; i < arrays.size(); i++) {
            int size = arrays.get(i).size();
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(size - 1);

            result = Math.max(result, Math.abs(currMin - max));
            result = Math.max(result, Math.abs(currMax - min));
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);

        }

        return max;
    }
}
