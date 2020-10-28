package pascal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }

        int numOfElements = 1;
        ans.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = ans.get(i - 1);

            for (int j = 0; j < numOfElements; j++) {
                int up = prev.size() >= (j + 1) ? prev.get(j) : 0;
                int left = j - 1 >= 0 ? prev.get(j - 1) : 0;

                ans.get(i).add(up + left);
            }
            numOfElements++;
        }
        return ans;
    }
}
