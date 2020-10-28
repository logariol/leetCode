package decodeWays;

public class DPOptimized {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int preLast = 1;
        int last = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i += 1) {
            int current = 0;
            // Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
                current += last;
            }

            // Check if successful two digit decode is possible.
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += preLast;
            }

            preLast = last;
            last = current;
        }
        return last;

    }
}
