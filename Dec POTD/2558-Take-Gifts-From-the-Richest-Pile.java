class Solution {
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> (b - a));

        for(int num : gifts){
            pq.add(num);
        }

        while(k > 0 && pq.peek() > 1){
            pq.add((int)Math.sqrt(pq.poll()));
            k--;
        }

        for(int val : pq){
            sum += val;
        }
        return sum;
    }
}