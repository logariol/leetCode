package bestTimeToBuyAndSellStock.ones;

public class Solution {
    /**
     * Approach: At each day calculate profit that can be made at that day by taking min price seen so far and substracting that from prices[i] (price at that day)
     * Time complexity : o(n), space complexity : o(1);
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int sell = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;

        for (int price : prices) {
            buy = Math.min(buy, price);
            sell = Math.max(price - buy, sell);
        }

        return sell;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));

    }
}
