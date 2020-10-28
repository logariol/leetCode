package criticalConnections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    int id = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);

            adj[from].add(to);
            adj[to].add(from);
        }

        int[] ids = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];


        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, -1, ids, low, visited, ret);
            }
        }
        return ret;
    }

    private void dfs(ArrayList<Integer>[] adj, int at, int parent, int[] ids, int[] low, boolean[] visited, List<List<Integer>> ret) {
        id++;
        ids[at] = low[at] = id;
        visited[at] = true;

        for (int to : adj[at]) {
            if (parent == to) {
                continue;
            }
            if (!visited[to]) {
                dfs(adj, to, at, ids, low, visited, ret);
                if (ids[at] < low[to]) {
                    ret.add(Arrays.asList(at, to));
                }
            }
            low[at] = Math.min(low[at], low[to]);
        }
    }

    public static void main(String[] args) {
/*
6
[[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]
 */
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> f = new ArrayList<>();
        f.add(0);
        f.add(1);

        list.add(f);

        List<Integer> f1 = new ArrayList<>();
        f1.add(1);
        f1.add(2);

        list.add(f1);

        List<Integer> f2 = new ArrayList<>();
        f2.add(2);
        f2.add(0);

        list.add(f2);

        List<Integer> f3 = new ArrayList<>();
        f3.add(1);
        f3.add(3);

        list.add(f3);

        List<Integer> f4 = new ArrayList<>();
        f4.add(3);
        f4.add(4);

        list.add(f4);

        List<Integer> f5 = new ArrayList<>();
        f5.add(4);
        f5.add(5);

        list.add(f5);

        List<Integer> f6 = new ArrayList<>();
        f6.add(5);
        f6.add(3);

        list.add(f6);
        Solution s = new Solution();
        for (List<Integer> criticalConnection : s.criticalConnections(6, list)) {
            System.out.println(criticalConnection);
        }
    }
}
