package minimumDiffToSchedule;

public class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] F = new int[d + 1][n + 1];
        for (int i = 1; i <= n; i++) F[1][i] = Math.max(F[1][i - 1], jobDifficulty[i - 1]);
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= n; j++) {
                int currMax = 0;
                F[i][j] = Integer.MAX_VALUE;
                for (int k = j; k >= i; k--) {
                    currMax = Math.max(currMax, jobDifficulty[k - 1]);
                    F[i][j] = Math.min(F[i][j], currMax + F[i - 1][k - 1]);
                }
            }

        }

        return F[d][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6);
    }
}
