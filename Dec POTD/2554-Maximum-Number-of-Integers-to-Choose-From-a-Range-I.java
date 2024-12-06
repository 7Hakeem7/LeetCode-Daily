class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        //the only thing you need to do is
        //choose the numbers that are not in arr[], between 1 - n , totalSum <= maxSum;
        //take a HashMap of banned numbers
        //traverse values 1 - n and check if the currVal exists in Map
        //if not then add it to total sum and count++
        ArrayList<Integer>list=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<banned.length;i++){
         map.put(banned[i],1);
        }
        int i=1;
        while(i<=n){
            if(!map.containsKey(i)){
                list.add(i);
            }
            i++;
        }
        int count=0;
        int sum=0;
        for( i=0;i<list.size();i++){
            sum+=list.get(i);
            if(sum>maxSum){
                break;
            }
            else{
                count++;
            }
        }
        return count;
    }
}