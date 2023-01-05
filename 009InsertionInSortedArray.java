package Day_0105;

class InsertionInSortedArray{
    public static int searchInsert(int[] array, int target){
        int left = 0;
        int right = array.length;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid]>=target){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        return left;
    }
}