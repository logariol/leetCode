package topKFrequentWords;

import java.util.LinkedList;
import java.util.List;

public class TrieSolution {
    class Trie {
        int cnt;
        int low;
        int high;
        String str;
        Trie[] children;

        Trie() {
        }

        Trie insert(String str, int lvl) {
            if (lvl >= str.length()) {
                if (cnt == 0) {
                    this.str = str;
                }
                cnt++;
                return this;
            }

            int idx = str.charAt(lvl) - 'a';
            if (children == null) {
                children = new Trie[26];
                low = high = idx;
            }

            if (children[idx] == null) {
                children[idx] = new Trie();
                if (idx < low)
                    low = idx;
                else if (idx > high) {
                    high = idx;
                }
            }
            return children[idx].insert(str, lvl + 1);
        }

        void traverse() {
            if (children != null) {
                for (int i = high; i >= low; i--) {
                    if (children[i] == null)
                        continue;
                    children[i].traverse();
                }
            }
            if (cnt > 0) {
                ListTrie listTrie = new ListTrie(this);
                listTrie.next = listTries[cnt];
                listTries[cnt] = listTrie;
            }
        }
    }

    class ListTrie {
        Trie trie;
        ListTrie next;

        ListTrie(Trie trie) {
            this.trie = trie;
        }
    }

    ListTrie[] listTries;

    public List<String> topKFrequent(String[] words, int k) {
        Trie root = new Trie();
        int maxCnt = 0;
        for (String word : words) {
            Trie trie = root.insert(word, 0);
            if (trie.cnt > maxCnt) {
                maxCnt = trie.cnt;
            }
        }

        listTries = new ListTrie[maxCnt + 1];
        root.traverse();
        LinkedList<String> rslts = new LinkedList<>();
        int rest = k;
        for (int i = maxCnt; i >= 0 && rest > 0; i--) {
            ListTrie listTrie = listTries[i];
            while (rest > 0 && listTrie != null) {
                rslts.add(listTrie.trie.str);
                rest--;
                listTrie = listTrie.next;
            }
        }
        return rslts;
    }

    public static void main(String[] args) {
        TrieSolution s = new TrieSolution();
        System.out.println(s.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
