class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int last = 0;
        long swapCount = 0;
        for(int curr = 0; curr < n ; curr++){
            if(s.charAt(curr) == '0'){
                swapCount += (curr - last);
                last++;
            }
            
        }
        return swapCount;
    }
}