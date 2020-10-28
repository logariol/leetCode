package searchInSortedArray;

public class Solution {
    interface ArrayReader {
        public int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int s = 0, e = Integer.MAX_VALUE;
        while (s <= e) {
            int mid = (s + e) / 2;
            int x = reader.get(mid);
            if (x == Integer.MAX_VALUE || x > target)
                e = mid - 1;
            else if (x < target)
                s = mid + 1;
            else
                return mid;
        }
        return -1;
    }


}
