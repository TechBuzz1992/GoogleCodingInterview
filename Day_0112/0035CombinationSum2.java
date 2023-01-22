package Day_0112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<Integer>(), solutions, candidates, target, 0);
        return solutions;
    }

    private void backtrack(List<Integer> partialSolution, List<List<Integer>> solutions, int[] candidates, int target, int startIndex) {
        if (target == 0) {
            solutions.add(new ArrayList(partialSolution));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int start = startIndex; start < candidates.length; start++) {
            if (start > startIndex && candidates[start] == candidates[start - 1]) {

                continue;
            }
            partialSolution.add(candidates[start]); // makeMove
            backtrack(partialSolution, solutions, candidates, target - candidates[start], start + 1); // (start + 1) because we can cannot reuse same element and need to move on to next element
            partialSolution.remove(partialSolution.size() - 1); // undoMove
        }
    }
}