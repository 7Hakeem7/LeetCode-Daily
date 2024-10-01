class Solution {
    public boolean canArrange(int[] arr, int k) {
        //maintain the frequency for the remainders we got (upto k)
        int[] freq = new int [k];

        //for each number in arr take out the remainder
        for (int num : arr){
            int rem = num % k;
            //if the remainder goes -ve make it +ve by adding k to it
            if(rem < 0){
                rem = rem + k;
            }
            //add it to the frequency check array of remainders
            freq[rem]++;
        }
        //for remainder 0 there should be even number of count
        if(freq[0] % 2 != 0)return false;

        //for the other remainders : if i is 3 then it should find (k - 3)rem
        for (int i = 1; i<= k / 2; i++){
            if(freq[i] != freq[k-i])return false;
        }
        return true;
    }
}