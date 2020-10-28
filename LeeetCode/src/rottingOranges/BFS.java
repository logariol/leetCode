package rottingOranges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity : O(nm). Space complexity : at most O(nm);
 */
public class BFS {
    public int orangesRotting(int[][] grid) {
        int epochs = 0;

        Queue<Item> queue = new LinkedList<>();
        int freshCnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Item(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }

        return freshCnt > 0 ? rot(queue, grid, freshCnt) : 0;
    }

    private int rot(Queue<Item> queue, int[][] grid, int freshCnt) {

        int epoch = 0;
        while (!queue.isEmpty()) {
            final Item gridI = queue.poll();
            epoch = gridI.epoch;

            int col = gridI.j;
            int row = gridI.i;

            if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 2;
                queue.add(new Item(row, col + 1, epoch + 1));
                freshCnt--;
            }
            if (col > 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 2;
                queue.add(new Item(row, col - 1, epoch + 1));
                freshCnt--;
            }

            if (row > 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 2;
                queue.add(new Item(row - 1, col, epoch + 1));
                freshCnt--;
            }

            if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 2;
                queue.add(new Item(row + 1, col, epoch + 1));
                freshCnt--;
            }
        }

        return freshCnt > 0 ? -1 : epoch;
    }

    static class Item {
        int j;
        int i;
        int epoch;

        public Item(int i, int j, int epoch) {
            this.j = j;
            this.i = i;
            this.epoch = epoch;
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 2, 2, 1, 1}};
//        int[][] a = new int[][]{{2, 2}, {1, 1}, {0, 0}, {2, 0}};
        BFS d = new BFS();
        //[[2,2,2,1,1]]
        System.out.println(d.orangesRotting(a));

    }
}
