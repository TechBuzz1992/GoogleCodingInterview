package Day_0125;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFromDataStream{
    PriorityQueue<Integer> minHeap; // higher half
    PriorityQueue<Integer> maxHeap; // lower half

    public MedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    }

    public void addNum(int num) {
        if (maxHeap.size() < minHeap.size()) {
            if (minHeap.peek() < num) {
                maxHeap.offer(minHeap.poll()); // O(logN) operation
                minHeap.offer(num); // O(logN) operation
            } else {
                maxHeap.offer(num); // O(logN) operation
            }
        } else {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                minHeap.offer(maxHeap.poll()); // O(logN) operation
                maxHeap.offer(num); // O(logN) operation
            } else {
                minHeap.offer(num); // O(logN) operation
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek(); // O(1) operation
        }
        return (double)(minHeap.peek() + maxHeap.peek()) / 2; // O(1) operation
    }
}