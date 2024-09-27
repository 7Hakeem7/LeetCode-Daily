class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long num = n;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        double result = 1;
        while (num > 0) {
            if (num % 2 == 1) {
                result *= x;
            }
            x *= x;  // Square the base
            num /= 2; // Divide the exponent by 2
        }
        return result;
    }
}