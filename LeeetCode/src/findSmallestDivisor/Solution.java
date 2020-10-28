package findSmallestDivisor;

public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = 1_000_000;
        while (min < max) {
            int divisor = (min + max) / 2;
            int sum = 0;
            for (int val : nums) {
                sum += (val + divisor - 1) / divisor;
            }
            if (sum > threshold) min = divisor + 1;
            else max = divisor;
        }
        return min;
    }
}
