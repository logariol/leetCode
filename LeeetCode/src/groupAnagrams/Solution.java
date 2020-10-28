package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    /**
     * Time complexity : (n wlogw). n - number of wordsm w length of longest word
     * Space complexity: o(nw);
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            char[] k = str.toCharArray();
            Arrays.sort(k);

            String sorted = new String(k);
            if (!anagrams.containsKey(sorted)) {
                anagrams.put(sorted, new ArrayList<>(Arrays.asList(str)));
            } else anagrams.get(sorted).add(str);

        }

        return new ArrayList<>(anagrams.values());
    }
}
