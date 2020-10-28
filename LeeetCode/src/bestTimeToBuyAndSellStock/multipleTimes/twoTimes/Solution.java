package bestTimeToBuyAndSellStock.multipleTimes.twoTimes;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int tran1Cost = Integer.MAX_VALUE;
        int tran1Profit = 0;
        int tran2Cost = Integer.MAX_VALUE;
        int tran2Profit = 0;

        for (int price : prices) {
            tran1Cost = Math.min(tran1Cost, price);
            tran1Profit = Math.max(tran1Profit, price - tran1Cost);

            tran2Cost = Math.min(tran2Cost, price - tran1Profit);
            tran2Profit = Math.max(tran2Profit, price - tran2Cost);
        }

        return tran2Profit;
    }
}
