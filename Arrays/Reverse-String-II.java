class Solution {
    public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        for(int i = 0 ; i <= n - 1; i += 2*k){
            if(i + k - 1 <= n - 1){
                reverse(i, i + k - 1, charArr);
            }else{
\t\t\t\t//for fewer than k characters left (edge case)
                reverse(i, n - 1, charArr);
            }
        }
        return new String(charArr);
        
    }
    private void reverse(int s, int e, char[] a){
        while(s < e){
            char temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }
}