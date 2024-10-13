class Solution {
    public int minGroups(int[][] intervals) {
        // Step 1: Find the maximum endpoint in all intervals
        int maxElement = 0;
        for (int[] inter : intervals) {
            maxElement = Math.max(maxElement, inter[1]);  // Get the maximum 'right' value
        }

        // Step 2: Create a prefix array of size (maxElement + 2) to handle the range of intervals
        int[] prefixArray = new int[maxElement + 2];

        // Step 3: Populate the prefix array using the intervals
        for (int[] inter : intervals) {
            int left = inter[0];
            int right = inter[1];
            prefixArray[left] += 1;      // Start of an interval
            prefixArray[right + 1] -= 1; // End of an interval (right + 1 means one point after the interval)
        }

        // Step 4: Calculate the prefix sums and find the maximum value (i.e., the maximum number of overlapping intervals)
        int minGroups = 1;  // At least 1 group is needed if there's any interval
        minGroups = Math.max(minGroups, prefixArray[0]);  // Initialize with the first element
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] += prefixArray[i - 1];  // Compute prefix sum
            minGroups = Math.max(minGroups, prefixArray[i]);  // Track the maximum overlap
        }

        // Step 5: Return the minimum number of groups required
        return minGroups;
    }
}