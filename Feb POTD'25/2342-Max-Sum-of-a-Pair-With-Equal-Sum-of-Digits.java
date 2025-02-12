import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        int maxSum = -1;
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores <digit sum, max value>

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i], currSum = 0;
            while (n > 0) { 
                currSum += n % 10;  // Extract last digit and add to sum
                n /= 10;            // Remove last digit
            }

            // If the digit sum is already in the map, update maxSum
            if (map.containsKey(currSum)) {
                maxSum = Math.max(maxSum, nums[i] + map.get(currSum));
                map.put(currSum, Math.max(map.get(currSum), nums[i])); // Store max value for this sum
            } else {
                map.put(currSum, nums[i]);
            }
        }

        return maxSum;
    }
}
