package subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new LinkedList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> curr, int[] nums, int start) {
        result.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            curr.add(nums[i]);
            backtrack(result, curr, nums, i + 1);
            curr.removeLast();
        }

    }
}
