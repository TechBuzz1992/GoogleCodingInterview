package Day_0125;

import java.util.HashSet;
import java.util.PriorityQueue;

class UglyNumberII{
    public static final int[] allowedPrimes = {2,3,5};

    public static int uglyNumber(int n){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashSet<Integer> usedNums = new HashSet<>();
        minHeap.offer(1);
        for(int i = 0;i<n-1; i++){
            int res = minHeap.poll();
            for(int multiplier : allowedPrimes){
                if(!usedNums.contains(res*multiplier)){
                    minHeap.add(res*multiplier);
                    usedNums.add(res*multiplier);
                }
            }
        }
        return minHeap.poll();
    }
}