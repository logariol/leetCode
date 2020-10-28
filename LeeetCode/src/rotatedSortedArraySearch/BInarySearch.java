package rotatedSortedArraySearch;

/**
 * Binary search. TIme complexity : o(logn)
 */
public class BInarySearch {
    public int search(int[] nums, int target) {
        return shiftedBinarySearch(nums, target, 0, nums.length - 1);
    }

    private static int shiftedBinarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            int leftNum = array[left];
            int rightNum = array[right];
            int potentialM = array[middle];

            if (array[middle] == target) return middle;

            if (leftNum <= potentialM) {
                // Left side is sorted
                if (target < potentialM && target >= leftNum) {
                    // Target could be on the left
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // Right side sorted
                if (target > potentialM && target <= rightNum) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
