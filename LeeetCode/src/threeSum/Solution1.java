package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Time complexity : nlogn for sort. n^2 for search. O(n^2)
 * Space complexity : O(logn) to logn depending on sorting algo.
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniques = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            // Avoid duplications
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSums(nums, i, uniques);
            }
        }

        return uniques;
    }

    private void twoSums(int[] nums, int i, List<List<Integer>> uniques) {
        var seen = new HashSet<Integer>();

        for (int j = i + 1; j < nums.length; j++) {
            int compl = -(nums[i] + nums[j]);
            if (seen.contains(compl)) {
                uniques.add(Arrays.asList(nums[i], nums[j], compl));
                // Avoid duplications
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
            }
            seen.add(nums[j]);
        }
    }
}
