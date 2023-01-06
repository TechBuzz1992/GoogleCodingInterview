package Day_0106;

class HonuEatingBananas{
    public static int minEatingSpeed(int[] piles, int H){
        long sum = 0;
        for(int bananas : piles){
            sum += bananas;
        }
        long left = ((sum-1)/H) + 1; //taking ceiling
        long right = sum;
        while(left<=right){
            long mid = left + (right-left)/2;
            if(isFeasible(piles, H, mid)){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return (int) left;

    }

    private static boolean isFeasible(int[] piles, int H, long speed){
        int hours = 0;
        for(int bananas : piles){
            hours += ((bananas - 1)/H) + 1;
        }
        return hours<=H;
    }


}