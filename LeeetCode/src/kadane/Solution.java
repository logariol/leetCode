package kadane;

import java.util.ArrayList;

public class Solution {
    public int kadanesAlgorithm(int[] array) {
        int max = array[0];
        int current = array[0];
        for (int i = 1; i < array.length; i++) {
            current = Math.max(array[i], current + array[i]);
            max = Math.max(max, current);
        }


        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kadanesAlgorithm(new int[]{9, -10, 15, 20, 7}));
    }
}
