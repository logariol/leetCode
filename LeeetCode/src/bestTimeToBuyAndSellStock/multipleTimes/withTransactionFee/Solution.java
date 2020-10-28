package bestTimeToBuyAndSellStock.multipleTimes.withTransactionFee;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int cash = 0, hold = -prices[0];

        for (int price : prices) {

            // Sell a stock. Cache = profit per transaction + balance if we held a stock at prev day
            cash = Math.max(cash, price - fee + hold);

            // Buy a stock
            hold = Math.max(hold, cash - price);

        }

        return cash;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(s.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
