class Pair{
    int num;
    int index;
    Pair(int num , int index){
        this.num = num;
        this.index = index;
    }
}

class Solution{
    public long findScore(int[] nums){
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a , Pair b) -> {
            if(a.num != b.num)return (a.num - b.num);//!equal then comp value
            else return (a.index - b.index);//equal val then comp indexes
        });

        long score = 0;
        //insert the nums into pq
        for(int i = 0; i < nums.length; i++){
            pq.add(new Pair(nums[i] , i));
        }

        while(!pq.isEmpty()){
            int value = pq.peek().num;
            int position = pq.peek().index;
            pq.poll();

            if(nums[position] == -1) continue;

            score += value;
            nums[position] = -1;

            if(position + 1 < nums.length) nums[position + 1] = -1;
            if(position - 1 >= 0) nums[position -1] = -1;
        }
        return score;
    }
}