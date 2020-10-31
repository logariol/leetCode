package consequtiveNumbersSum;

public class Solution {
    class Solution1 {
        public int consecutiveNumbersSum(int N) {
            int count = 0;
            // x > 0 --> N/k - (k + 1)/2 > 0
            int upper_limit = (int) (Math.sqrt(2 * N + 0.25) - 0.5);
            for (int k = 1; k <= upper_limit; ++k) {
                // x should be an integer
                if ((N - k * (k + 1) / 2) % k == 0)
                    count++;
            }
            return count;
        }
    }

    static class Solution2 {
        public int consecutiveNumbersSum(int N) {
            int count = 0;
            int upper_limit = (int) (Math.sqrt(2 * N + 0.25) - 0.5);
            for (int k = 1; k <= upper_limit; ++k) {
                N -= k;
                if (N % k == 0)
                    count++;
            }
            return count;
        }

        public static void main(String[] args) {
            Solution2 s = new Solution2();
            System.out.println(s.consecutiveNumbersSum(15));
        }

    }


}
