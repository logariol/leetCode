package removeDuplicateLetters;

public class Solution {
    public static String removeDuplicateLetters(String s) {

        char[] chars = s.toCharArray();

        int[] counts = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (char c : chars) {
            index = c - 'a';
            counts[index]--;

            if (visited[index]) continue;

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && counts[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.charAt(sb.length() - 1));
            }
            sb.append(c);
            visited[index] = true;
        }


        return sb.toString();
    }
}
