package Day_0106;

class FindFirstAndLastIndex{
    public static int[] searchRange(int[] array, int target){
        int firstIndex = findFirstIndex(array, target);
        int lastIndex = findLastIndex(array, target);
        return new int[]{firstIndex, lastIndex};
    }

    private static int findLastIndex(int[] array, int target) {
        if(array == null || array.length == 0 || target<array[0] || target > array[array.length-1]){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid] > target){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        if(array[left] == target){
            return left;
        }
        if(array[left-1] !=target){
            return -1;
        }
        return left-1;
    }

    private static int findFirstIndex(int[] array, int target) {
        if(array == null || array.length == 0 || target<array[0] || target > array[array.length-1]){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid] >= target){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        if(array[left] != target){
            return -1;
        }
        return left;
    }
}