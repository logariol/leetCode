package productExceptSelf;


public class Solution {

    /**
     * Time : O(n) Space o(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        if (nums.length == 1) return new int[]{0};
        int[] before = new int[nums.length];
        before[0] = nums[0];

        int[] after = new int[nums.length];
        after[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
            before[i] = before[i - 1] * nums[i];
            after[j] = after[j + 1] * nums[j];
        }

        int[] ans = new int[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = before[i - 1] * after[i + 1];
        }

        ans[0] = after[1];
        ans[nums.length - 1] = before[nums.length - 2];

        return ans;

    }

}
