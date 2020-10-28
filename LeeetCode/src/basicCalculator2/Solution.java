package basicCalculator2;

import java.util.LinkedList;

public class Solution {

    static class Stack {
        /**
         * Time complexity o(n). Space complexity : O(n);
         *
         * @param s
         * @return
         */
        public static int calculate(String s) {
            if (s == null || s.isEmpty()) return 0;
            LinkedList<Character> opers = new LinkedList<>();
            LinkedList<Integer> nums = new LinkedList<>();

            int idx = 0;
            while (idx < s.length()) {
                char c = s.charAt(idx);
                if (Character.isDigit(c)) {
                    StringBuilder sb = new StringBuilder();
                    while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                        sb.append(s.charAt(idx));
                        idx++;
                    }
                    idx--;
                    int currentNum = Integer.parseInt(sb.toString());

                    if (opers.isEmpty()) {
                        nums.add(currentNum);
                    } else {
                        Character lastOper = opers.getLast();

                        if (lastOper == '*') {
                            nums.add(nums.removeLast() * currentNum);
                            opers.removeLast();
                        } else if (lastOper == '/') {
                            nums.add(nums.removeLast() / currentNum);
                            opers.removeLast();
                        } else {
                            nums.add(currentNum);
                        }
                    }
                } else if (c == '/' || c == '*' || c == '+' || c == '-') {
                    opers.add(c);
                }
                idx++;
            }

            int res = nums.getFirst();
            nums.removeFirst();
            for (int n : nums) {
                if (opers.getFirst() == '+') {
                    res += n;
                } else res -= n;
                opers.removeFirst();
            }

            return res;
        }
    }

    static class NoStack {
        public static int calculate(String s) {
            if (s == null) return 0;
            s = s.trim().replaceAll(" +", "");
            int length = s.length();

            int res = 0;
            long preVal = 0; // initial preVal is 0
            char sign = '+'; // initial sign is +

            int i = 0;
            while (i < length) {
                long curVal = 0;
                while (i < length && (int) s.charAt(i) <= 57 && (int) s.charAt(i) >= 48) { // int
                    curVal = curVal * 10 + (s.charAt(i) - '0');
                    i++;
                }

                if (sign == '+') {
                    res += preVal;
                    preVal = curVal;
                } else if (sign == '-') {
                    res += preVal;
                    preVal = -curVal;
                } else if (sign == '*') {
                    preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
                } else if (sign == '/') {
                    preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
                }

                if (i < length) {
                    sign = s.charAt(i);
                    i++;
                }
            }

            res += preVal;
            return res;
        }
    }

}
