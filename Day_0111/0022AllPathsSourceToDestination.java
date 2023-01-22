package Day_0111;

import java.util.ArrayList;
import java.util.List;

class AllPathsSourceToDestination{
    public List<List<Integer>> allPaths(int[][] graph){
        List<List<Integer>> res = new ArrayList<>();
        if(graph == null || graph.length == 0){
            return res;
        }
        int N = graph.length - 1;
        List<Integer> partialSolution = new ArrayList<>();
        partialSolution.add(0);
        backtrack(0, graph, partialSolution, res, N);
        return res;
    }

    private void backtrack(int nodeID, int[][] graph, List<Integer> partialSolution, List<List<Integer>> result, int N){
        if(nodeID == N){
            result.add(new ArrayList<Integer>(partialSolution));
            return;
        }
        int[] candidates = graph[nodeID];
        for(int candidate : candidates){
            partialSolution.add(candidate);
            backtrack(candidate, graph, partialSolution, result, N);
            partialSolution.remove(partialSolution.size()-1);
        }
    }
}