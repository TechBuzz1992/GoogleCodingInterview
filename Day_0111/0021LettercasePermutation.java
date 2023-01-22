package Day_0111;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation{
    public List<String> letterCasePermutation(String S){
        List<String> result = new ArrayList<>();
        if(S== null || S.length() == 0){
            return result;
        }
        char[] word = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        backtrack(0, word, sb, result);
        return result;
    }

    private void backtrack(int index, char[] word, StringBuilder partialSolution, List<String> result){
        if(index == word.length){
            result.add(partialSolution.toString());
            return;
        }
        char[] candidates = constructCandidates(index, word);
        for(char candidate : candidates){
            partialSolution.append(candidate);
            backtrack(index+1, word, partialSolution, result);
            partialSolution.setLength(partialSolution.length()-1);
        }
    }

    private char[] constructCandidates(int index, char[] word){
        return Character.isDigit(word[index]) ? new char[]{word[index]} : new char[] {Character.toLowerCase(word[index]), Character.toUpperCase(word[index])};
    }
}