package longestSubstringNoRepeats;

public class Main {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        long t = System.currentTimeMillis();
        System.out.println(s.lengthOfLongestSubstring("qwertyuiopasdfghjklzxcvbnmq"));
        System.out.println(System.currentTimeMillis() - t);

        Solution1 s1 = new Solution1();
        t = System.currentTimeMillis();
        System.out.println(s1.lengthOfLongestSubstring("qwertyuiopasdfghjklzxcvbnm"));
        System.out.println(System.currentTimeMillis() - t);

        Solution s2 = new Solution();
        t = System.currentTimeMillis();
        System.out.println(s2.lengthOfLongestSubstring("qwertyuiopasdfghjklzxcvbnm"));
        System.out.println(System.currentTimeMillis() - t);
    }
}
