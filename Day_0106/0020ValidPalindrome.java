package Day_0106;

class ValidPalindrome{
    public static boolean isPalindrome(String str){
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left<right){
            while(left<right && !Character.isLetterOrDigit(str.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(str.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))){
               return false;
            }
            left++;
            right--;
        }
        return true;
    }
}