package Day_0112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PalindromePermutation{
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        backtrack(new boolean[s.length()], ch, new StringBuilder(), res);
        return res;
    }

    // used[i] is true if s[i] is already use where s is the given string, false otherwise
    private void backtrack(boolean[] used, char[] ch, StringBuilder partialSolution, List<String> solutions) {
        if (partialSolution.length() == ch.length) {
            if (isPalindrome(partialSolution.toString())) {
                solutions.add(partialSolution.toString());
            }
            return;
        }
        List<Integer> candidateIndices = generateCandidates(used, ch);
        for (int candidateIndex : candidateIndices) {

            partialSolution.append(Character.toString(ch[candidateIndex])); // makeMove
            used[candidateIndex] = true; // makeMove

            backtrack(used, ch, partialSolution, solutions); // call backtrack( ... ) recursively

            partialSolution.setLength(partialSolution.length() - 1); // undoMove
            used[candidateIndex] = false; // undoMove
        }
    }

    private List<Integer> generateCandidates(boolean[] used, char[] ch) {
        List<Integer> candidateIndices  = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            if (!used[i]) {
                if (i > 0 && !used[i - 1] && ch[i] == ch[i - 1]) {
                    // This is where we are handling duplicates and making sure we do not have same configurations
                    // in the solution more than once.
                    continue;
                }
                candidateIndices.add(i);
            }
        }
        return candidateIndices;
    }

    private boolean isPalindrome(String input) {
        char[] ch = input.toCharArray();
        int beg = 0;
        int end = ch.length - 1;
        while (beg < end) {
            if (ch[beg] != ch[end]) {
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }
}