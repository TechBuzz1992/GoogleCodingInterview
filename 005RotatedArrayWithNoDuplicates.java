package Day_0105;

class RotatedArrayWithNoDuplicates {
    public static int search(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        while(start<=end){
            int mid = start + (end- start)/2;
            if(array[mid] == target) return mid;
            else if(array[mid]>=array[start]){
                if(target>=array[start] && target<array[mid]) end = mid-1;
                else start = mid+1;
            } else{
                if(target>array[mid] && target<=array[end]) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;

    }
}
