package Day_0106;

class FindMinInRotatedArray{
    public static int findMin(int[] array){
        int len = array.length;
        if(array.length == 1 || array[0] < array[len-1]){
            return array[0];
        }
        int left = 0;
        int right = len - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid]<=array[mid-1]){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        return array[left];
    }
}