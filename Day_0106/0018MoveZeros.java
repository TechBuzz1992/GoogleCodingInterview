package Day_0106;

class MoveZeros{
    public static void moveZeros(int[] array){
        int slow = 0;
        for(int fast = 0;fast<array.length;fast++){
            if(array[fast]!=0){
                int slowNum = array[slow];
                array[slow] = array[fast];
                array[fast] = slowNum;
                slow++;
            }
        }
    }
}