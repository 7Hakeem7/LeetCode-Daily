// class Solution {
//     public int maxCount(int[] banned, int n, int maxSum) {
        //the only thing you need to do is
        //choose the numbers that are not in arr[], between 1 - n , totalSum <= maxSum;
        //take a HashMap of banned numbers
        //take an arraylist of size n with values 1 to n
        //traverse list and check if the currVal exists in Map
        //if not then add it to total sum and add it to the Map and count++
        //do search = abs.(totalSum - maxSum) in the list
        //
//     }
// }

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] arr=new int[10001];
        for(int i=0; i<banned.length; i++){
            arr[banned[i]]=1;
        }

        long sum=0;
        int cnt=0;
        for(int i=1; i<=n; i++){
            if(arr[i]==1){continue;}
            sum+=i;
            if(sum>maxSum){
               break;
            }
            cnt++;
        }

        return cnt;
    }
}