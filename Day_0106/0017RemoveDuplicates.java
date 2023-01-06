package Day_0106;

class RemoveDuplicates{
    public static int removeDuplicates(int[] array){
        int slow = 0;
        for(int fast = 0;fast<array.length;fast++){
            if(array[slow]!=array[fast]){
                slow++;
                array[slow] = array[fast];
            }
        }
        return slow+1;
    }
}