package letterCombinations;

import java.util.*;

public class Solution {
    static final Map<Character, List<Character>> dict = new HashMap<>();

    static {
        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'n', 'o'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {


        List<String> permutations = getNext(digits, 0, dict, new StringBuilder());
        return permutations;

    }


    private List<String> getNext(String digits, int level, Map<Character, List<Character>> map, StringBuilder sb) {
        List<String> permutations = new ArrayList<>();
        if (digits.length() <= level) {
            permutations.add(sb.toString());
            return permutations;
        }

        List<Character> levelChars = map.get(digits.charAt(level));
        for (Character levelChar : levelChars) {
            sb.append(levelChar);
            List<String> next = getNext(digits, level + 1, map, sb);
            permutations.addAll(next);
            sb.deleteCharAt(sb.length() - 1);
        }

        return permutations;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("2379").size());
    }

}
