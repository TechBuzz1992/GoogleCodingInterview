package Day_0112;

import java.util.ArrayList;
import java.util.List;

class CombinationSum{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), solutions, candidates, target, 0);
        return solutions;
    }

    private void backtrack(List<Integer> partialSolution, List<List<Integer>> solutions, int[] candidates, int target, int startIndex) {
        if (target == 0) {
            solutions.add(new ArrayList<Integer>(partialSolution));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int start = startIndex; start < candidates.length; start++) {
            partialSolution.add(candidates[start]); // makeMove
            backtrack(partialSolution, solutions, candidates, target - candidates[start], start); // NOT (start + 1) because we can reuse same elements
            partialSolution.remove(partialSolution.size() - 1); // undoMove
        }
    }
}