package subarraySumEqualK;

import java.util.HashMap;

public class Optimal {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            sum += num;
            // Match found, increase
            if (sum == k) count++;
            // Found mathces before? Increase
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            // Update sum counter
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
