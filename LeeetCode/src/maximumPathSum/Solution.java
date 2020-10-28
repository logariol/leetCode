package maximumPathSum;

public class Solution {
    static class TwoDimensionalDp {

        /**
         * Approach: keep min path sum at each cell
         * Time and space complexity : O(n*m)
         *
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;

            int[][] dp = new int[grid.length][grid[0].length];
            dp[0][0] = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    dp[i][j] += grid[i][j];
                    if (i == 0 && j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    } else if (i > 0 && j == 0) {
                        dp[i][j] += dp[i - 1][j];
                    } else if (i > 0 && j > 0) {
                        dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[grid.length - 1][grid[0].length - 1];
        }
    }

    static class Recursive {

        public int minPathSum(int[][] grid) {
            int[][] memo = new int[grid.length][grid[0].length];
            int x = grid.length - 1;
            int y = grid[0].length - 1;
            return getMinimumPath(grid, memo, x, y);
        }

        private int getMinimumPath(int[][] grid, int[][] memo, int x, int y) {
            if (x == 0 && y == 0) {
                return grid[0][0];
            } else if (x < 0 || y < 0) {
                return Integer.MAX_VALUE;
            } else if (memo[x][y] != 0) {
                return memo[x][y];
            } else {
                memo[x][y] = grid[x][y] + Math.min(getMinimumPath(grid, memo, x - 1, y), getMinimumPath(grid, memo, x, y - 1));
                return memo[x][y];
            }
        }

    }

    static class OneDimensionalDp {
        /**
         * Approach: keep min path sum for each column
         * Time and space complexity : O(n*m)
         *
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int[] dp = new int[grid[0].length];
            dp[0] = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j > 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    } else if (i > 0 && j == 0) {
                        dp[j] = dp[j] + grid[i][j];
                    } else if (i > 0 && j > 0) {
                        dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                    }
                }
            }

            return dp[grid[0].length - 1];
        }
    }
}
