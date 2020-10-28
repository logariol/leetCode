package medianOfSortedArrays;

import java.util.Arrays;

public class Solution {
    static class WithMerge {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0) return getMedian(nums2);
            if (nums2.length == 0) return getMedian(nums1);

            int[] m = merge(nums1, nums2);

            return getMedian(m);

        }

        private int[] merge(int[] nums1, int[] nums2) {
            int left = 0, right = 0;
            int mergedIdx = 0;
            int[] merged = new int[nums2.length + nums1.length];
            while (left < nums1.length && right < nums2.length) {
                if (nums1[left] < nums2[right]) {
                    merged[mergedIdx++] = nums1[left++];
                } else {
                    merged[mergedIdx++] = nums2[right++];
                }
            }
            while (right < nums2.length) {
                merged[mergedIdx++] = nums2[right++];
            }
            while (left < nums1.length) {
                merged[mergedIdx++] = nums2[left++];
            }
            return merged;
        }

        private double getMedian(int[] arr) {
            int size = arr.length;

            if (size % 2 != 0) return arr[size / 2];
            return ((double) arr[size / 2] + (double) arr[size / 2 - 1]) / 2;


        }

        public static void main(String[] args) {
            WithMerge s = new WithMerge();
            System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 10};
        System.out.println(Arrays.binarySearch(a, 7) + 1);
    }
}
