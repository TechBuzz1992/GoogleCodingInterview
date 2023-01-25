package Day_0125;

import java.util.Comparator;
import java.util.PriorityQueue;

class HeapImplementation{
    public static void main(String[] args){
        int[] array = {100, 9, 5, 400, 5, 5, 8, 9898989, -1, -3, 55};
        minHeap(array);
        System.out.println();
        maxHeap(array);
    }

    private static void minHeap(int[] array){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int a : array){
            minHeap.offer(a);
        }
    }

    private static void maxHeap(int[] array){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int a : array){
            minHeap.offer(a);
        }
    }
}