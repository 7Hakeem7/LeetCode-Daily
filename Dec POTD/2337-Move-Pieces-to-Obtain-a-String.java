class Solution {
    public boolean canChange(String st, String tar) {
        //two pointers -> keep left and right
        //move the right on the first piece of target6 from left to right, get the the position of it;
        //move the left till it matches the char at right
        int n = tar.length();
        int i=0,j=0;
        while(i<=n && j<=n){
            
            while(i<n && tar.charAt(i)=='_') i++;
            while(j<n && st.charAt(j)=='_') j++;
            
            if(i==n || j==n){
                return i==n && j==n;
            }
            
            if(tar.charAt(i)!=st.charAt(j)) return false;
            
            if(tar.charAt(i)=='L'){
                if(j<i) return false;
            }
            else{
                if(i<j) return false;
            }
            
            i++;
            j++;
        }
        return true;
    }
}