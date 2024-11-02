class Solution {
    public boolean isCircularSentence(String sentence) {
        //we move forward till we find space
        int n = sentence.length();
        char space = ' ';
        boolean cond1 = true;
        boolean cond2 = true;

        if(sentence.charAt(n - 1) != sentence.charAt(0)){
                cond1 = false;
        }

        for(int i = 0 ; i < n - 1 ; i++){   
            if(sentence.charAt(i) == space && sentence.charAt(i - 1) != sentence.charAt(i + 1)){
                cond2 = false;
            }
        }
        
        if(cond1 == true && cond2 == true){
            return true;
        }
        else{
            return false;
        }
    }
}