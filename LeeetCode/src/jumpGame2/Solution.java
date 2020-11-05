package jumpGame2;

import java.util.Arrays;

public class Solution {
    public int jumpDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int cnt = nums[i];
            while (cnt > 0) {
                if (i + cnt < n) {
                    dp[i + cnt] = Math.min(dp[i + cnt], dp[i] + 1);
                }
                cnt--;
            }
        }
        return dp[n - 1];
    }

    public int jumpGreedy(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        // max position one could reach
        // starting from index <= i
        int maxPos = nums[0];
        // max number of steps one could do
        // inside this jump
        int maxSteps = nums[0];

        int jumps = 1;
        for (int i = 1; i < n; ++i) {
            // if to reach this point
            // one needs one more jump
            if (maxSteps < i) {
                ++jumps;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jumpDP(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.jumpDP(new int[]{2, 3, 0, 1, 4}));
    }
}
