package wordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Fastest {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        HashSet<String> dic = new HashSet<>(wordList);
        HashSet<String> s1 = new HashSet<>();
        HashSet<String> s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        return helper(dic, s1, s2, 1);
    }

    public int helper(HashSet<String> dic, HashSet<String> s1, HashSet<String> s2, int level) {
        if (s1.isEmpty()) return 0;
        if (s1.size() > s2.size()) return helper(dic, s2, s1, level);

        for (String s : s1)
            dic.remove(s);

        for (String s : s2)
            dic.remove(s);

        HashSet<String> temp = new HashSet<>();
        for (String s : s1) {
            for (int i = 0; i < s.length(); i++) {
                char[] arr = s.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String t = new String(arr);
                    if (s2.contains(t))
                        return level + 1;
                    if (dic.contains(t))
                        temp.add(t);
                }
            }
        }

        return helper(dic, temp, s2, level + 1);
    }


    public static void main(String[] args) {
        Fastest c = new Fastest();
        c.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

}
