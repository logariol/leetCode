package minimumRemoveToMakeValid;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.isEmpty()) return s;

        int unOpen = 0, closingCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            // Count number of closing parentheses
            if (s.charAt(i) == ')') closingCnt++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // Don't have any closing parethenses left
                if (closingCnt == unOpen) {
                    continue;
                }
                // Add one '(' to balance
                unOpen++;
            } else if (c == ')') {

                closingCnt--;

                // Nothing to balance, skip ')'
                if (unOpen == 0) continue;
                // Balance brackets
                unOpen--;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
