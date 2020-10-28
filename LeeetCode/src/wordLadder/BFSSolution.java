package wordLadder;

import java.util.*;

public class BFSSolution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> w = new HashSet<>(wordList);
        if (!w.contains(endWord)) return 0;

        List<String> compl = new ArrayList<>();
        compl.add(beginWord);
        compl.addAll(wordList);
        Graph g = new Graph(compl, endWord);

        return g.minPath;
    }

    static class Graph {
        public final ArrayList<Integer>[] adj;
        public int[] pathTo;
        public String endWord;
        public int minPath;
        public boolean[] visited;
        int endIdx;

        /*
            Time comlexity : At most O(n^2) + O(2V). V is the number of words
            Space comlexity : n to store path, 2n on adjecency list of the graph

         */
        public Graph(List<String> dict, String endWord) {
            int v = dict.size();
            this.adj = new ArrayList[v];
            this.endWord = endWord;
            endIdx = dict.indexOf(endWord);
            pathTo = new int[v];
            Arrays.fill(pathTo, Integer.MAX_VALUE);
            pathTo[0] = -1;

            visited = new boolean[v];

            // o(n) time. O(n) space
            for (int i = 0; i < dict.size(); i++) {
                adj[i] = new ArrayList<>();
            }

            // O(n^2) time
            for (int i = 0; i < dict.size(); i++) {
                for (int j = i + 1; j < dict.size(); j++) {
                    int dist = getDistance(dict.get(i), dict.get(j));
                    if (dist == 1) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }


            minPath = bfs();
        }

        private int bfs() {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            queue.add(endIdx);

            while (!queue.isEmpty()) {
                final Integer vert = queue.poll();
                final ArrayList<Integer> list = adj[vert];
                visited[vert] = true;

                for (Integer v : list) {
                    if (pathTo[v] == Integer.MAX_VALUE) pathTo[v] = vert;
                    if (!visited[v]) queue.add(v);
                }

            }

            int startIdx = endIdx;
            if (pathTo[startIdx] == Integer.MAX_VALUE) return 0;

            int cnt = 1;

            while (pathTo[startIdx] != Integer.MAX_VALUE && pathTo[startIdx] != -1) {
                cnt++;
                startIdx = pathTo[startIdx];
            }

            return cnt;
        }


        /*
            Calculate distance in chars between words.
         */
        private static int getDistance(String s, String s1) {
            int distance = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i)) {
                    distance++;
                }
            }
            return distance;
        }
    }

    public static void main(String[] args) {
        BFSSolution s = new BFSSolution();
        System.out.println(s.ladderLength("hot", "dog", Arrays.asList("hot", "dog", "dot")));
        System.out.println(s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
