package Day_0105;

import java.util.List;

class FirstTrueInSortedArray{
    public static int firstTrue(List<Boolean> list){
        int start = 0;
        int end = list.size() - 1;
        int boundaryIndex = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(list.get(mid)){
                boundaryIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return boundaryIndex;
    }

}