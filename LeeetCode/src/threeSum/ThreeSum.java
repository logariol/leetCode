package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity : nlogn for sort. n^2 for search. O(n^2)
 * Space complexity : O(logn) to logn depending on sorting algo.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniques = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // Avoid duplications
            if (i == 0 || nums[i - 1] != nums[i]) {
                int k = i + 1;
                int l = nums.length - 1;
                while (l > k) {
                    int sum = nums[k] + nums[l] + nums[i];
                    if (sum == 0) {
                        uniques.add(Arrays.asList(nums[i], nums[k++], nums[l--]));
                        // Avoid duplications
                        while (k < l && nums[k] == nums[k - 1]) k++;
                    } else if (sum < 0) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }

        }

        return uniques;
    }
}
