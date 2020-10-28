package combinationsSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity : O(N ^ (T/M)) + nlogn where T is target and M is the min element in candidates. This is upper bound.
 * Due to sorting we can skip a lot of iterations.
 * Space complexity : O(T/M) at most we keep combination of numbers of length T/M. Output space is ignored.
 */
public class SortingSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, target, 0);

    }

    private List<List<Integer>> dfs(int[] candidates, int target, int idx) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[idx] < target) {
                final List<List<Integer>> res = dfs(candidates, target - candidates[idx], i);
                for (List<Integer> l : res) {
                    l.add(candidates[idx]);
                    result.add(l);
                }

            } else if (candidates[idx] == target) {
                List<Integer> l = new ArrayList<>();
                l.add(candidates[idx]);
                result.add(l);
            } else break;
        }
        return result;
    }
}
