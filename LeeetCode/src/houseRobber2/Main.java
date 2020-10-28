package houseRobber2;

public class Main {
    static class DPSolution {
        public int rob(int[] nums) {
            if (nums.length == 0)
                return 0;

            if (nums.length == 1)
                return nums[0];

            int max1 = robHouse(nums, 0, nums.length - 2);
            int max2 = robHouse(nums, 1, nums.length - 1);
            return Math.max(max1, max2);
        }

        private int robHouse(int[] nums, int start, int end) {
            int max = 0;
            int prevMax = 0;
            for (int i = start; i <= end; i++) {
                int temp = max;
                max = Math.max(max, prevMax + nums[i]);
                prevMax = temp;
            }

            return max;
        }
    }
}
