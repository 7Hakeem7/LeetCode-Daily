class Solution {
    public int getWinner(int[] arr, int k) {

        int currWinner = arr[0];
        int wins = 0;
        int maxPotentialPlayer = Integer.MIN_VALUE;//take the maxPotential player value out to optimize the solution , If he/she matches with anyone it will always be a win so...
        for(int i = 0; i< arr.length ; i++){
            maxPotentialPlayer = Math.max(maxPotentialPlayer , arr[i]);
        }

        //traverse from next player
        for(int i = 1 ; i < arr.length ; i++){
            int nextPlayer = arr[i];
            if(currWinner > nextPlayer){
                wins++;
            }
            else{
                currWinner = nextPlayer;
                wins = 1;
            }

            if(wins == k){
                return currWinner;
            }

            //this will terminate the process and declare the winner 
            if(currWinner == maxPotentialPlayer){
                return currWinner;
            }
        }
        return currWinner;
         
    }
}