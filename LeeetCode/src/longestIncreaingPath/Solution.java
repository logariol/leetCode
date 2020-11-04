package longestIncreaingPath;

public class Solution {
    static class Memorization {

        private final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0) return 0;

            int ans = 0;

            int[][] cache = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    ans = Math.max(ans, dfs(matrix, i, j, cache));
                }
            }
            return ans;
        }

        private int dfs(int[][] matrix, int i, int j, int[][] cache) {
            if (cache[i][j] != 0) return cache[i][j];

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                    cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
                }
            }
            return ++cache[i][j];
        }
    }

    static class Fastest {
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            var maxPath = 0;
            int[][] cache = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    maxPath = Math.max(maxPath(i, j, matrix, cache), maxPath);
                }
            }

            return maxPath;
        }

        private int maxPath(int i, int j, int[][] matrix, int[][] cache) {
            if (cache[i][j] != 0) {
                return cache[i][j];
            }


            int max = 1;
            if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
                max = Math.max(maxPath(i - 1, j, matrix, cache) + 1, max);
            }

            if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
                max = Math.max(maxPath(i + 1, j, matrix, cache) + 1, max);
            }

            if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
                max = Math.max(maxPath(i, j - 1, matrix, cache) + 1, max);
            }

            if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
                max = Math.max(maxPath(i, j + 1, matrix, cache) + 1, max);
            }

            cache[i][j] = max;
            return max;
        }
    }

}
