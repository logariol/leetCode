package Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0, nums.length - 1);
        return output;
    }

    private void backtrack(int[] nums, int start, int length) {
        if (start == length) {
            List<Integer> l = new ArrayList<>();
            for (int v : nums) {
                l.add(v);
            }
            output.add(l);
        } else {
            for (int i = start; i < length; i++) {
                swap(nums, start, i);
                backtrack(nums, i, nums.length - 1);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
