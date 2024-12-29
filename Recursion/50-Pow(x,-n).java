class Solution {
    public double myPow(double x, int n) {
        //if n is even do n/2 and x * x
        //if n is odd do x * x^n-1;
        //base cases:
        if (n < 0) {
            // Special handling for the case when n is Integer.MIN_VALUE
            if (n == Integer.MIN_VALUE) {
                return 1.0 / func(x, Integer.MAX_VALUE) / x;  // Handle overflow by using Integer.MAX_VALUE
            }
            return 1.0 / func(x, -n);  // Calculate power for positive n
        }
        return func(x, n);
        // return ans;
    }
    private double func(double x , int n){
        double val = 1;
        if(n == 0){
            return 1.0;
        }
        if(n % 2 == 1){
            val = x * func(x , n - 1);
        }
        else{
            n = n / 2;
            val = func(x * x , n);
        }
        return val;
    }
}