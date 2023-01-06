package Day_0106;

class TwoSumSorted{
    public static int[] twoSumSorted(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left<right){
            int twoSum = array[left] + array[right];
            if(twoSum == target){
                return new int[]{left, right};
            } else if(twoSum > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}