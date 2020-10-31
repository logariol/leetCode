package buddyString;

import java.util.*;

public class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) dif.add(i);
        }

        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        int parentIdx = (currentIdx - 1)/2;

        while (currentIdx > 0) {
            if (heap.get(currentIdx) < heap.get(parentIdx)) Collections.swap(heap, currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1)/2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        PriorityQueue<int[]> q = new PriorityQueue(Comparator.reverseOrder());

        System.out.println(s.buddyStrings("aa", "aa"));
    }
}
