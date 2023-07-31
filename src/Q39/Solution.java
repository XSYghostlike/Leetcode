package Q39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        combinationSumRecursion(candidates, 0, target, prefix, results);
        return results;
    }

    private void combinationSumRecursion(int[] candidates, int startIndex, int target, List<Integer> prefix, List<List<Integer>> accuResult) {
        if (startIndex == candidates.length) {
            if (target == 0) {
                List<Integer> result = new ArrayList<>(prefix);
                accuResult.add(result);
            }
            return;
        }
        int nextStartIndex = startIndex + 1;
        int newTarget = target;
        List<Integer> deepCopyPrefix = new ArrayList<>(prefix);
        combinationSumRecursion(candidates, nextStartIndex, newTarget, deepCopyPrefix, accuResult);
        while (newTarget >= candidates[startIndex]) {
            newTarget = newTarget-candidates[startIndex];
            prefix.add(candidates[startIndex]);
            List<Integer> deepCopyPrefixWithinLoop = new ArrayList<>(prefix);
            combinationSumRecursion(candidates, nextStartIndex, newTarget, deepCopyPrefixWithinLoop, accuResult);
        }
    }
}
