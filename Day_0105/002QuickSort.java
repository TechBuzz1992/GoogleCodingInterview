package Day_0105;

import java.util.List;

class QuickSort {

    public static void quickSortingList(List<Integer>list, int start, int end){
        if(end-start <= 1){
            return;
        }
        int pivot = list.get(end-1);
        int startPointer = start, endPointer = end-1;
        while(startPointer < endPointer){
            while(list.get(startPointer) < pivot && startPointer < endPointer){
                startPointer++;
            }
            while(list.get(endPointer) >= pivot && startPointer < endPointer){
                endPointer--;
            }
            if(startPointer == endPointer){
                break;
            }
            int temp = list.get(startPointer);
            list.set(startPointer, list.get(endPointer));
            list.set(endPointer, temp);
        }

        int temp = list.get(startPointer);
        list.set(startPointer, list.get(end-1));
        list.set(end-1, temp);

        quickSortingList(list, start, startPointer);
        quickSortingList(list, startPointer + 1, end);

    }
}
