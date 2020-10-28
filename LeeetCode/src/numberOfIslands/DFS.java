package numberOfIslands;

/**
 * Number of islands solution using dfs approach
 * Time and space complexities: O(M * N) where M is the number of rows in grid, and N is the number of columns in grid.
 */
public class DFS {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int connectedC = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    connectedC++;
                    findConnComps(grid, i, j);
                }
            }
        }
        return connectedC;
    }

    private static void findConnComps(char[][] grid, int row, int col) {

        grid[row][col] = '0';
        if (valid(grid, row + 1, col)) {
            findConnComps(grid, row + 1, col);
        }
        if (valid(grid, row - 1, col)) {
            findConnComps(grid, row - 1, col);
        }
        if (valid(grid, row, col + 1)) {
            findConnComps(grid, row, col + 1);
        }
        if (valid(grid, row, col - 1)) {
            findConnComps(grid, row, col - 1);
        }
    }

    private static boolean valid(char[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1';
    }

}
