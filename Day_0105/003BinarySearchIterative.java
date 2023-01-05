package Day_0105;

class BinarySearchIterative {
    public static boolean binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid] == target){
                return true;
            } else if(array[mid] > target){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return false;
    }
}
