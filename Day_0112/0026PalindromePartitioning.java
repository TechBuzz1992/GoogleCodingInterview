package Day_0112;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning{
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, s, 0);
        return res;
    }

    public void backtrack(List<String> partialSolution, List<List<String>> allSolutions, String s, int start){
        if(start == s.length()) {
            allSolutions.add(new ArrayList<>(partialSolution));
            return;
        }

        // candidates would be all indices such that s[start...candidate] is a palindrome
        for(int candidate = start; candidate < s.length(); candidate++){ // candidates
            if(isPalindrome(s, start, candidate)){ //  proceed only if s[start...firstPalindromeSubstringEndIndex] is a palindrome
                partialSolution.add(s.substring(start, candidate + 1)); // makeMove
                backtrack(partialSolution, allSolutions, s, candidate + 1); // recursively call backtrack( ... )
                partialSolution.remove(partialSolution.size() - 1); // undoMove
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}