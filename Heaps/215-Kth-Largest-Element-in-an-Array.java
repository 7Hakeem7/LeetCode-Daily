class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

      
        int f = k - 1;

        while (f > 0) {
            pq.poll(); 
            f--;
        }  
        return pq.peek();
        
    }
}