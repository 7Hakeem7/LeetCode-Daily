import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the array to handle duplicates efficiently
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));  // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // If the current candidate exceeds the target, stop further processing
            if (candidates[i] > target) {
                break;
            }

            // Skip duplicates: only the first instance of each value is used
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Add the current candidate to the combination
            current.add(candidates[i]);

            // Recur with the next index and updated target
            backtrack(candidates, i + 1, target - candidates[i], current, ans);

            // Backtrack by removing the last added element
            current.remove(current.size() - 1);
        }
    }
}
