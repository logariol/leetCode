package maxProduct;

public class Solution {
    /**
     *
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Calculate product with minimum and current number
            int currentTimesMin = minSoFar * curr;
            // Calculate product with minimum and current number
            int currentTimesMax = maxSoFar * curr;

            int maxProduct = Math.max(currentTimesMax, currentTimesMin);
            int minProduct = Math.min(currentTimesMax, currentTimesMin);

            minSoFar = Math.min(curr, minProduct);
            maxSoFar = Math.max(curr, maxProduct);

            result = Math.max(maxSoFar, result);
        }
        return result;
    }
}
