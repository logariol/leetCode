package trappingRainWater;

public class Solution {
    public int trap(int[] h) {
        int[] leftMax = new int[h.length];
        leftMax[0] = h[0];
        int[] rightMax = new int[h.length];
        rightMax[h.length - 1] = h[h.length - 1];

        for (int i = 1; i < h.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], h[i]);
        }

        for (int i = h.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], h[i]);
        }
        int ans = 0;
        for (int i = 1; i < h.length - 1; i++) {
            System.out.println("Left " + leftMax[i] + " Right " + rightMax[i] + " heights " + h[i] + " To ans " + (Math.min(leftMax[i], rightMax[i]) - h[i]));
            ans += Math.min(leftMax[i], rightMax[i]) - h[i];
        }
        return ans;
    }

    public int trap1(int[] heights) {
        int leftIdx = 0;
        int rightIdx = heights.length - 1;
        int leftMax = heights[0];
        int rightMax = heights[rightIdx];

        int area = 0;
        while (leftIdx < rightIdx) {
            if (heights[leftIdx] < heights[rightIdx]) {
                leftIdx++;
                leftMax = Math.max(leftMax, heights[leftIdx]);
                area += leftMax - heights[leftIdx];

            } else {
                rightIdx--;
                rightMax = Math.max(rightMax, heights[rightIdx]);
                area += rightMax - heights[rightIdx];
            }
        }
        return area;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
