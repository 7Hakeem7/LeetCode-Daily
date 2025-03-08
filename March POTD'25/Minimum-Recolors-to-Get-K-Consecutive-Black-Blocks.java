class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE;
        //"W B B W W B B W B W"
        int left = 0, right = k - 1;;
        while(right < blocks.length()){
            int countW = 0;
            for(int i = left; i <= right; i++){
                if(blocks.charAt(i) == 'W'){
                    countW++;
                }
            }
            ans = Math.min(ans, countW);
            left++;
            right++;
        }
        return ans;
    }
}