class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0 , j = 0;
        int count = 0;

        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i)+1 == str2.charAt(j) || str1.charAt(i) == str2.charAt(j) || str1.charAt(i) == 'z' && str2.charAt(j) == 'a'){
                i++;
                j++;
                count++;
            }
            else{
                i++;
            }
            
        }
        return count == str2.length();
    }
}