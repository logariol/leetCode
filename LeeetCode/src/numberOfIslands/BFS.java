package numberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of islands solution using bfs approach
 * Time complexity: O(N * M)
 * Space complexity: if mutating grid then O(min(M, N)), otherwise O(N * M)
 */
public class BFS {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int connectedComps = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    connectedComps++;
                    markConnected(grid, i, j);
                }
            }
        }
        return connectedComps;
    }

    private static void markConnected(char[][] grid, int row, int col) {
        Queue<GridItem> queue = new LinkedList<>();
        queue.add(new GridItem(row, col));
        while (!queue.isEmpty()) {

            final GridItem gridItem = queue.poll();

            if (isValidMove(grid, gridItem.row + 1, gridItem.col)) {
                queue.add(new GridItem(gridItem.row + 1, gridItem.col));
                grid[gridItem.row + 1][gridItem.col] = '0';
            }

            if (isValidMove(grid, gridItem.row - 1, gridItem.col)) {
                queue.add(new GridItem(gridItem.row - 1, gridItem.col));
                grid[gridItem.row - 1][gridItem.col] = '0';
            }
            if (isValidMove(grid, gridItem.row, gridItem.col + 1)) {
                queue.add(new GridItem(gridItem.row, gridItem.col + 1));
                grid[gridItem.row][gridItem.col + 1] = '0';
            }

            if (isValidMove(grid, gridItem.row, gridItem.col - 1)) {
                queue.add(new GridItem(gridItem.row, gridItem.col - 1));
                grid[gridItem.row][gridItem.col - 1] = '0';
            }
        }
    }

    private static boolean isValidMove(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1';
    }

    private static class GridItem {
        final int row;
        final int col;

        public GridItem(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
