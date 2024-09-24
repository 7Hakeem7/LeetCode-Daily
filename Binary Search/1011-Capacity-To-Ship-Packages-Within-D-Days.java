class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0; 
        int totalSum = 0; 
        for (int i = 0; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            totalSum += weights[i];
        }

        if (days >= weights.length) return maxWeight; 
        if (days == 1) return totalSum;
        
        int lo = maxWeight; 
        int hi = totalSum; 
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            int neededDays = 1; 
            int curWeight = 0; 
            for (int weight: weights) {
                curWeight += weight; 
                if (curWeight > mid) {
                    curWeight = weight; 
                    neededDays += 1; 
                }
            }

            if (neededDays > days) {
                lo = mid + 1; 
            } else {
                hi = mid - 1; 
            }
        }
        return lo; 
    }
}