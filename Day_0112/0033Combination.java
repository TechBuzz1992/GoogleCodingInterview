package Day_0112;

import java.util.ArrayList;
import java.util.List;

class Combination{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), solutions, 1, n, k);
        return solutions;
    }
    public void backtrack(List<Integer> partialSolution, List<List<Integer>> solutions, int start, int n, int k) {
        if(k == 0) {
            solutions.add(new ArrayList<Integer>(partialSolution));
            return;
        }
        for(int candidate = start; candidate <= n; candidate++) { // candidates
            partialSolution.add(candidate); // makeMove
            backtrack(partialSolution, solutions, candidate + 1, n, k - 1); // EXPLORE FURTHER: call backtrack( ... ) recursively
            partialSolution.remove(partialSolution.size() - 1); // undoMove
        }
    }
}