import java.util.*;

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        List<Integer> indices = new ArrayList<>();
        
        // Collect all indices
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }
        
        // Sort the indices based on the values at nums[i]
        Collections.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));
        
        int minIndex = Integer.MAX_VALUE;
        int maxRamp = 0;
        
        // Traverse the sorted indices and calculate the ramp width
        for (int index : indices) {
            maxRamp = Math.max(maxRamp, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }
        
        return maxRamp;
    }
}
