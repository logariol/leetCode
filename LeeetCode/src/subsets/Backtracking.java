package subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity : n * 2^n. Ar each step we double number of subsets.
 * Space complexity : to build longest sub set is n. number of sub sets = 2 ^ n; so we use n * 2^n;
 */

public class Backtracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, nums, new LinkedList<>(), 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, LinkedList<Integer> curr, int start) {
        // Deep copy to result.
        result.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(result, nums, curr, i + 1);
            curr.removeLast();
        }
    }

}
