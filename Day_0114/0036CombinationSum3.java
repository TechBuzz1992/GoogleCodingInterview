package Day_0114;

import java.util.ArrayList;
import java.util.List;

class CombinationSum3{
    public List<List<Integer>> combinationSum3(int k, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), result, new int[]{1,2,3,4,5,6,7,8,9}, target, 0, k);
        return result;
    }

    private void backtrack(List<Integer> partialSolution, List<List<Integer>> result, int[] candidates, int target, int startIndex, int remainingElements){
        if(remainingElements == 0 && target == 0){
            result.add(new ArrayList<>(partialSolution));
            return;
        }
        if(remainingElements<0 || target < 0){
            return;
        }
        for(int start = startIndex; start<candidates.length;start++){
            partialSolution.add(candidates[start]);
            backtrack(partialSolution, result, candidates, target-candidates[start], startIndex+1, remainingElements-1);
            partialSolution.remove(partialSolution.size()-1);
        }
    }
}