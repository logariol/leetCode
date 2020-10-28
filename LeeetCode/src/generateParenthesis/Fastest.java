package generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Fastest {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, 0, 0, new StringBuilder());
        return result;
    }

    private void generate(List<String> result, int n, int openCnt, int closingCnt, StringBuilder sb) {
        if (openCnt == n && closingCnt == n) {
            result.add(sb.toString());
            return;
        }
        // left can never be less than right, otherwise it would be invalid
        if (openCnt > closingCnt) {
            sb.append(')');
            generate(result, n, openCnt, closingCnt + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (openCnt < n) {
            sb.append('(');
            generate(result, n, openCnt + 1, closingCnt, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
