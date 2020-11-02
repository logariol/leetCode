package findMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    static class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            minHeap.add(num);
            if (!maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() - 1 > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) return 0;
            double minHeapHead = minHeap.peek() == null ? 0 : minHeap.peek();
            double maxHeapHead = maxHeap.peek() == null ? 0 : maxHeap.peek();


            if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
                return (minHeapHead + maxHeapHead) / 2;
            } else {
                return minHeapHead;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        System.out.println(m.findMedian());

        m.addNum(-2);
        System.out.println(m.findMedian());

        m.addNum(-3);
        System.out.println(m.findMedian());

        m.addNum(-4);
        System.out.println(m.findMedian());

        m.addNum(-5);
        System.out.println(m.findMedian());
    }
}
