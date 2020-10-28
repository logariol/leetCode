package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity : n * 2^n. Ar each step we double number of subsets.
 * Space complexity : n * 2^n.
 */
public class Iterative {
    public List<List<Integer>> subsets(int[] array) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        for (int ele : array) {
            int len = result.size();
            for (int i = 0; i < len; i++) {
                final List<Integer> curr = new ArrayList<>(result.get(i));

                curr.add(ele);

                result.add(curr);

            }
        }

        return result;
    }
}
