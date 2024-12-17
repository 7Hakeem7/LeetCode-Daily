class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        //we are traversing from the back and we are taking the min of the currchar or rate limit and decreasing it from the freq
        StringBuilder newStr = new StringBuilder();
        int [] freq = new int[26];

        for(int ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        int index = 25;
        while(index >= 0){
            if(freq[index] == 0){
                index--;
                continue;
            }
            int used = Math.min(freq[index] , repeatLimit);
            for(int i = 0 ; i < used; i++){
                newStr.append((char) ('a' + index));
            }
            freq[index] -= used;

            if(freq[index] > 0){
                int prevIndex = index - 1;
                while(prevIndex >= 0 && freq[prevIndex] == 0){
                    prevIndex--;
                }
                if(prevIndex < 0){
                    break;
                }
                newStr.append((char) ('a' + prevIndex));
                freq[prevIndex]--;
            }
        }
        return newStr.toString();
    }
}