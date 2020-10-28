package numberOfIslands;

public class Main {
    public static void main(String[] args) {

    /*
        ['1','1','1','1','0'],
        ['1','1','0','1','0'],
        ['1','1','0','0','0'],
     */
        char[][] c = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}
        };
        System.out.println(BFS.numIslands(c));

        char[][] k = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(BFS.numIslands(k));
    }
}
