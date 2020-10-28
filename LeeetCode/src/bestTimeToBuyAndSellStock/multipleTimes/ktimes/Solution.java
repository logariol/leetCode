package bestTimeToBuyAndSellStock.multipleTimes.ktimes;

public class Solution {
    public int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;
        int[][] profits = new int[k + 1][prices.length];

        for (int t = 1; t <= k; t++) {
            int maxThusFar = Integer.MIN_VALUE;

            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]);
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]);
            }
        }
        return profits[k][prices.length - 1];
    }

    public int maxProfit2(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;


        int[] evenProfits = new int[prices.length];
        int[] oddProfits = new int[prices.length];

        int[] currentProfits;
        int[] prevProfits;

        for (int t = 1; t < k + 1; t++) {
            int maxThusFar = Integer.MIN_VALUE;

            if (t % 2 == 1) {
                currentProfits = oddProfits;
                prevProfits = evenProfits;
            } else {
                currentProfits = evenProfits;
                prevProfits = oddProfits;
            }

            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, prevProfits[d - 1] - prices[d - 1]);
                currentProfits[d] = Math.max(currentProfits[d - 1], maxThusFar + prices[d]);

            }
        }

        return k % 2 == 0 ? evenProfits[prices.length - 1] : oddProfits[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {5, 11, 3, 50, 60, 90};
        s.maxProfit(a, 2);
    }
}
