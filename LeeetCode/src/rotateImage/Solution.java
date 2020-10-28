package rotateImage;

public class Solution {
    static class CopyArray {
        public void rotate(int[][] matrix) {
            final int[][] clone = new int[matrix.length][matrix[0].length];


            int row = 0;
            for (int c = matrix[0].length - 1; c >= 0; c--) {
                for (int k = 0; k < matrix.length; k++) {
                    clone[k][c] = matrix[row][k];
                }
                row++;
            }

            for (int i = 0; i < clone.length; i++) {
                System.arraycopy(clone[i], 0, matrix[i], 0, clone[0].length);
            }
        }
    }

    static class TransposeReverse {
        public void rotate(int[][] matrix) {
            int n = matrix.length;

            // transpose matrix
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
            // reverse each row
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = tmp;
                }
            }
        }
    }
}
