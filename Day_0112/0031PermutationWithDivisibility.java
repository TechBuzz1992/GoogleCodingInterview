package Day_0112;

import java.util.ArrayList;
import java.util.List;

class PermutationWithDivisibility{
    int count = 0;
    public int countArrangement(int N){
        backtrack(1, new boolean[N],N);
        return count;
    }

    private void backtrack(int partialSolution, boolean[] used, int N){
        if(partialSolution == N+1){
            count++;
            return;
        }
        List<Integer> candidates = generateCandidates(used, partialSolution);
        for(int candidate : candidates){
            used[candidate-1] = true;
            backtrack(partialSolution+1, used, N);
            used[candidate] = false;

        }
    }

    private List<Integer> generateCandidates(boolean[] used, int partialSolution) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<used.length;i++){
            if(!used[i] && (i+1)%partialSolution == 0 || partialSolution%(i+1) == 0){
                res.add(i+1);
            }
        }
        return res;
    }
}