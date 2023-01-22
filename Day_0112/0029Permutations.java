package Day_0112;

import java.util.ArrayList;
import java.util.List;

class Permutations{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(new boolean[nums.length], nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(boolean[] used, int[] nums, List<Integer> partialSolution, List<List<Integer>> solutions) {
        if (partialSolution.size() == nums.length) {
            solutions.add(new ArrayList<Integer>(partialSolution));
            return;
        }
        List<Integer> candidateIndices = generateCandidates(used);
        for (int candidateIndex : candidateIndices) {

            partialSolution.add(nums[candidateIndex]); // makeMove
            used[candidateIndex] = true; // makeMove

            backtrack(used, nums, partialSolution, solutions); // call backtrack( ... ) recursively

            partialSolution.remove(partialSolution.size() - 1); // undoMove
            used[candidateIndex] = false; // undoMove
        }
    }

    private List<Integer> generateCandidates(boolean[] used) {
        List<Integer> candidates  = new ArrayList<>();
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                candidates.add(i);
            }
        }
        return candidates;
    }
}