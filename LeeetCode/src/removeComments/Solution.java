package removeComments;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < line.length() && chars[i] == '*' && chars[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(newline.toString());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        s.removeComments(source);

    }

}
