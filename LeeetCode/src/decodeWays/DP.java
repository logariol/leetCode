package decodeWays;

public class DP {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = 1;

        for (int i = 2; i < dp.length; i += 1) {

            // Try to decoth ith char in s. Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
                // Does' not decrease total number
                dp[i] = dp[i - 1];
            }

            // Check if successful two digit decode is possible.
            // If i-1th and ith characters can be decoded together
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];

    }
}
// 10. [1, 1, 0]
// [1, 1, 0]
// [1,]
