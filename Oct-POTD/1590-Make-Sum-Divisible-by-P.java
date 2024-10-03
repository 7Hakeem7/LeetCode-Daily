import java.util.HashMap;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        if (totalSum == 0) return 0;  // If the total sum is divisible by p, no subarray needs to be removed.

        int target = totalSum;
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);  // Initialize with mod 0 at index -1 for edge cases.
        int prefixSum = 0, minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int neededMod = (prefixSum - target + p) % p;  // Calculate the mod we need to find in the map.

            if (modMap.containsKey(neededMod)) {
                minLength = Math.min(minLength, i - modMap.get(neededMod));
            }
            modMap.put(prefixSum, i);  // Update the map with the current prefix sum.
        }

        return minLength == nums.length ? -1 : minLength;  // If no valid subarray was found, return -1.
    }
}
