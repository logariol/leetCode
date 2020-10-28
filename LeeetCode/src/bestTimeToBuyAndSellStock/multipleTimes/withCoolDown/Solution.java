package bestTimeToBuyAndSellStock.multipleTimes.withCoolDown;

public class Solution {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, rest = 0,
                held = Integer.MIN_VALUE;

        for (int price : prices) {
            int prevSold = sold;

            sold = held + price;
            held = Math.max(held, rest - price);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
