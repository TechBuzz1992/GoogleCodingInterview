package Day_0105;

import java.util.ArrayList;
import java.util.List;

class MergeSort {
    public static List<Integer> mergeSortingList(List<Integer> list, int start, int end){
        if(end-start <= 1){
            return list.subList(start, end);
        }
        int midpoint = start + (end-start)/2;
        List<Integer> leftList = mergeSortingList(list, start, midpoint);
        List<Integer> rightList = mergeSortingList(list, midpoint, end);

        ArrayList<Integer> result = new ArrayList<>();
        int leftPointer = 0, rightPointer = 0;
        while(leftPointer < leftList.size() || rightPointer < rightList.size()){
            if(leftPointer == leftList.size()){
                result.add(rightList.get(rightPointer));
                rightPointer++;
            } else if(rightPointer == rightList.size()){
                result.add(leftList.get(leftPointer));
                leftPointer++;
            } else if(leftList.get(leftPointer) <= rightList.get(rightPointer)){
                result.add(leftList.get(leftPointer));
                leftPointer++;
            } else{
                result.add(rightList.get(rightPointer));
                rightPointer++;
            }
        }
        return result;
    }
}
