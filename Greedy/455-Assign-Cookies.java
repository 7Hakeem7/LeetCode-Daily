class Solution {
    public int findContentChildren(int[] student, int[] cookie) {
        int n = student.length;
        int m = cookie.length;
        Arrays.sort(student);
        Arrays.sort(cookie);
        int cookiePointer =0 , stdntPointer =0 ;
        while(cookiePointer < m && stdntPointer < n){
            if(cookie[cookiePointer] >= student[stdntPointer] ){
                //we're done assigning this student , move to the next one
                stdntPointer++;
            }
            cookiePointer++;
        
        }
        return stdntPointer;
    }
}