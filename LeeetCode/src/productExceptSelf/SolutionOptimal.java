package productExceptSelf;

public class SolutionOptimal {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] ans = new int[nums.length];

        ans[0] = 1;
        // Calculate all products before ith number;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int right = 1;
        // R will hold product of all values to the right of i
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }

        return ans;
    }
}
