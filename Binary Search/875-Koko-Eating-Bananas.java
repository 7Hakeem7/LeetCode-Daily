class Solution {
  public int findMax(int arr[])
  {
    int max =Integer.MIN_VALUE;
    for(int a:arr) max = Math.max(max,a);
    return max;
  }
  public int findTotalHrs(int[] arr,int hrs)
  {
    int tot =0;
    for(int i=0;i<arr.length;i++)
    {
      tot+= Math.ceil((double)(arr[i])/hrs);
    }
    return tot;
  }
    public int minEatingSpeed(int[] arr, int h) {
        int low =1;
        int high = findMax(arr); 
        int ans=1;
        while(low<=high)
        {
          int mid = (low+high)/2;
          int totalhrs = findTotalHrs(arr,mid);
          
          if(totalhrs<=h)
          {
            ans=mid;
            high = mid-1;
          }
          else low = mid+1;
        }
        return ans;     //we can return low also
    }
}

// import java.util.List;

// class Solution {

//     private static int getMax(int[] piles) {
//         int max = Integer.MIN_VALUE;
//         for (int pile : piles) {
//             if (pile > max) {
//                 max = pile;
//             }
//         }
//         return max;
//     }
    
//     private static boolean feasible(int speed, int[] piles, int h) {
//         int totalHours = 0;
//         for (int pile : piles) {
//             totalHours += (pile - 1) / speed + 1;
//         }
//         return totalHours <= h;
//     }
    
//     public int minEatingSpeed(int[] piles, int h) {
//         int left = 1;
//         int right = getMax(piles);

//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (feasible(mid, piles, h)) {
//                 right = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }

//         return left;
//     }
// }