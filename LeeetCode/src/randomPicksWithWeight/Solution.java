package randomPicksWithWeight;

public class Solution {
    int[] prefixSums;
    int totalSum;

    public Solution(int[] w) {
        prefixSums = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSums[i] = totalSum;
        }
    }

    public int pickIndex() {
        double target = totalSum * Math.random();

        int lo = 0, hi = prefixSums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (target > prefixSums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
