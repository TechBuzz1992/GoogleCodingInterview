package Day_0105;

class FindMinimumInRotatedSortedArrayWithDuplicates{
    public static int findMinimum(int[] array){
        int low = 0;
        int high = array.length-1;

        while(low<=high){
            int pivot = low +(high-low)/2;
            if(array[pivot]<array[high]){
                high = pivot;
            } else if(array[pivot]>array[high]){
                low = pivot+1;
            } else{
                high = high-1;
            }
        }
        return array[low];
    }
}