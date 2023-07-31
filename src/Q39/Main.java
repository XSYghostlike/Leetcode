package Q39;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> results = s.combinationSum(candidates, 7);
        for (List<Integer> result : results) {
            System.out.println(Arrays.toString(result.toArray()));
        }
    }
}
