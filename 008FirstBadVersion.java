package Day_0105;

class FirstBadVersion{
    public static int firstBadVersion(int n){
        int left  = 1;
        int right = n;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int mid) {
        return true;
    }
}