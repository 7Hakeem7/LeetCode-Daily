
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        
        // Prefix sum array to store cumulative sums. 
        // s[i] represents the sum of the first i elements of nums.
        long[] s = new long[n + 1]; 
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i]; // Calculate cumulative sum
        }

        // Deque to store indices of elements in the prefix sum array
        Deque<Integer> q = new ArrayDeque<>();
        int ans = n + 1; // Initialize the answer with a value larger than the array size

        for (int i = 0; i <= n; i++) {
            // Check if the current subarray sum is at least k
            while (!q.isEmpty() && s[i] - s[q.peek()] >= k) {
                // Update the answer with the minimum length found
                ans = Math.min(ans, i - q.poll());
            }

            // Maintain the deque in increasing order of prefix sums
            // Remove indices from the back whose prefix sum is greater or equal to the current sum
            while (!q.isEmpty() && s[q.peekLast()] >= s[i]) {
                q.pollLast(); // Remove unnecessary indices
            }

            // Add the current index to the deque
            q.offer(i);
        }

        // If no valid subarray is found, return -1
        return ans > n ? -1 : ans;
    }
}