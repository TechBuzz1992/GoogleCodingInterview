package Day_0112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PowerSetWithDuplicates{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> partialSolution, List<List<Integer>> completeSolution) {
        if (start > nums.length - 1) {
            processSolution(partialSolution, completeSolution);
            return;
        }
        if (isASolution(start)) {
            // print the subset you just got before moving on to
            // prepending it to the next number
            processSolution(partialSolution, completeSolution);
        }
        for (int i = start; i < nums.length; i++) {
            // Handle duplicate combinations
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            makeMove(nums[i], partialSolution);
            // prepend nums[index] to
            // each of the subsets we get from
            // computing powerset of nums[(index + 1) ....(nums.length - 1)]
            backtrack(nums, i + 1, partialSolution, completeSolution);
            undoMove(partialSolution);
        }
    }

    private boolean isASolution(int index) {
        return true; // always return true since
        // we are printing powerset
        // we print all unique (no duplicates allowed) partial solutions.
        // In short, every partial solution is a solution for power set.
    }

    private void processSolution(List<Integer> partialSolution, List<List<Integer>> completeSolution) {
        completeSolution.add(new ArrayList<Integer>(partialSolution));
    }

    private void makeMove(int candidate, List<Integer> partialSolution) {
        partialSolution.add(candidate);
    }

    private void undoMove(List<Integer> partialSolution) {
        partialSolution.remove(partialSolution.size() - 1); // the candidate
        // we would need to remove would always be the last element
        // at the time of deletion
    }
}