package bestTimeToBuyAndSellStock.multipleTimes;

public class Solution {

    public int maxProfit(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public boolean find132pattern1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; j++, k--) {
                if (nums[i] < nums[k]) {
                    if (nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k]) {
                        if (nums[k] < nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.find132pattern(new int[]{42, 43, 6, 12, 3, 4, 6, 11, 20}));
        System.out.println(s.find132pattern1(new int[]{42, 43, 6, 12, 3, 4, 6, 11, 20}));
    }


}
