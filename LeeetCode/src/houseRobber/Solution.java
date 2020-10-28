package houseRobber;

public class Solution {
    static class DpSolution {
        public int rob(int[] nums) {
            if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];

            int[] dp = new int[nums.length];

            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[dp.length - 1];
        }
    }

    static class DpOptimized {
        public int rob(int[] nums) {
            if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
            int currentMax = 0;
            int prevMax = 0;

            for (int num : nums) {
                int temp = currentMax;
                currentMax = Math.max(prevMax + num, currentMax);
                prevMax = temp;
            }
            return currentMax;
        }
    }
}
