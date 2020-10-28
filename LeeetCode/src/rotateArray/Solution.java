package rotateArray;

public class Solution {
    static class CycleRotate {
        public static void rotate(int[] nums, int k) {
            int movesDone = 0;

            int[] nextMove = new int[]{-1, -1};
            for (int start = 0; movesDone < nums.length; start++) {
                nextMove[0] = start;
                nextMove[1] = nums[start];
                do {
                    nextMove = move(nums, nextMove, k);
                    movesDone++;
                } while (nextMove[0] != start);
            }
        }

        private static int[] move(int[] nums, int[] moveObj, int moveBy) {
            int idx = moveObj[0];
            int value = moveObj[1];

            int newIdx = (idx + moveBy) % nums.length;
            int valueAtNewIdx = nums[newIdx];

            nums[newIdx] = value;

            return new int[]{newIdx, valueAtNewIdx};

        }
    }

}
