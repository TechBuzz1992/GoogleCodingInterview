package Day_0112;

import java.util.ArrayList;
import java.util.List;

class PowerSets{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, 0, new boolean[nums.length], res);
        return res;
    }

    private void backtrack(int[] nums, int index, boolean[] partialSolution, List<List<Integer>> completeSolution) {
        if (isASolution(index, nums.length - 1)) {
            processSolution(partialSolution, completeSolution, nums);
            return;
        }
        boolean[] candidates = generateCandidates();
        for (boolean candidate : candidates) {
            makeMove(candidate, partialSolution, index);
            backtrack(nums, index + 1, partialSolution, completeSolution);
            undoMove(partialSolution, index);
        }
    }

    private boolean[] generateCandidates() {
        return new boolean[] { true, false };
    }

    private boolean isASolution(int index, int n) {
        return index > n;
    }

    private void processSolution(boolean[] partialSolution, List<List<Integer>> completeSolution, int[] nums) {
        List<Integer> subset = new ArrayList<>();
        for (int index = 0; index < partialSolution.length; index++) {
            if (partialSolution[index]) {
                subset.add(nums[index]);
            }
        }
        completeSolution.add(subset);
    }

    private void makeMove(boolean candidate, boolean[] partialSolution, int index) {
        partialSolution[index] = candidate;
    }

    private void undoMove(boolean[] partialSolution, int index) {
        partialSolution[index] = false;
    }
}