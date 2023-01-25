package Day_0125;

import java.util.PriorityQueue;

class KthLargestElementInArray{
    public int getKthLargestElement(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a- b);
        for(int n  :nums){
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}