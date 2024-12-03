class Solution {
    public String addSpaces(String s, int[] spaces) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (j < spaces.length && spaces[j] == i) {
                ans.append(' ');
                ++j;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();

        //HashSet of Spaces
        //new Empty string = ""
        //traverse on s.charAt(i) where i < s.length();
        //check if 'i' exists in set
        //if so -> then add space right there newStr + " "
        //if not -> then add the curr char to newStr + s.charAt(i)
        //return the new string.

        // HashSet<Integer> set = new HashSet<>();
        // String finalStr = "";

        // for(int i = 0; i< spaces.length; i++){
        //     set.add(spaces[i]);
        // }

        // for(int i = 0; i < s.length(); i++){
        //     if(!set.contains(i)){
        //         finalStr += s.charAt(i);
        //     }
        //     else{
        //         finalStr += " " + s.charAt(i);
        //     }
        // }
        // return finalStr;

    }
}