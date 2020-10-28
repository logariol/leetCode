package coinChange;

public class Main {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int am = coin; am < amount + 1; am++) {
                dp[am] += dp[am - coin];
            }
        }

        return dp[amount];
    }
}
