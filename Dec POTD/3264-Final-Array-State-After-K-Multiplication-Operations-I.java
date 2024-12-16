class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //take a priority queue  minHeap
        //get the top and x multiplier and k --;
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a , Pair b) ->{
            if(a.value != b.value) return (a.value - b.value);
            else return (a.index - b.index);
        });

        for(int i = 0; i < nums.length; i++){
            pq.offer(new Pair(nums[i] , i));
        }

        while(k-- > 0){
            int currMin = pq.peek().value;
            int currIndex = pq.peek().index;
            int x = currMin * multiplier;
            pq.poll();
            pq.add(new Pair(x , currIndex));
        }

        while(!pq.isEmpty()){
            int currVal = pq.peek().value;
            int atPosition = pq.peek().index;
            nums[atPosition] = currVal;
            pq.poll();
        }
        return nums;
    }
}

class Pair{
    int value;
    int index;

    Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}