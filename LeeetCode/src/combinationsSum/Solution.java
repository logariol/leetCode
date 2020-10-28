package combinationsSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity : O(N ^ (T/M)) where T is target and M is the min element in candidates. This is upper bound
 * Space complexity : O(T/M) at most we keep combination of numbers of length T/M. Output space is ignored.
 */
public class Solution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combs = new LinkedList<>();

        backtrack(target, candidates, result, combs, 0);
        return result;
    }

    private void backtrack(int remaining, int[] candidates, List<List<Integer>> result, LinkedList<Integer> combs, int start) {
        if (remaining == 0) {
            // make a deep copy of the current combination
            result.add(new ArrayList<>(combs));
        }

        // exceed the scope, stop exploration.
        if (remaining < 0) return;

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination

            if (candidates[i] < remaining) {
                backtrack(remaining - candidates[i], candidates, result, combs, i);
            }
            // backtrack, remove the number from the combination
            combs.removeLast();
        }
    }

}
