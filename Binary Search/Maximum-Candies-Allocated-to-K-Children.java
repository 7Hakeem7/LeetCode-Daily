class Solution {
    public int maximumCandies(int[] candies, long k) {
        //Intuition -> binary Search on answers
        //low = 0, high = totalSum of candies pile
        //assume an answer and check if we can distribute it to k students
        //keep it maximum by moving to the right side
        //4,7,5  k = 3    0 3   7 8  16
        //if the max > k then return 0;
        // Binary Search on the answer
        int low = 1, high = 0;
        for (int c : candies) {
            high = Math.max(high, c);
        }
        
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(candies, mid, k)) {
                ans = mid;  // Store the best answer
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] candies, int mid, long k) {
        if (mid == 0) return false;  // Avoid division by zero
        long donateCount = 0;
        for (int c : candies) {
            donateCount += c / mid;  // Count how many `mid`-sized piles can be formed
        }
        return donateCount >= k;
    }
}