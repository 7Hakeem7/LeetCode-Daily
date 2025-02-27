class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num); // Use add() to maintain heap size properly
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.add(val);
        } 
        else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
    
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */