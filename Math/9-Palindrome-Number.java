class Solution {
    public boolean isPalindrome(int x) {
        // 1331
        long reverse = 0;
        int xcopy = x;
        while(x > 0){
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }
        return reverse == xcopy;
    }
}