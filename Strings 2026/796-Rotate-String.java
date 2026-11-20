class Solution {   
    public boolean rotateString(String s, String goal) {
        //your code goes here
        if (s.length() != goal.length()) {
            return false; 
        }
        // Try all possible rotations of s
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i); 
            if (rotated.equals(goal)) {
                return true;  // Return true if a match is found
            }
        }
        return false;  

    }
}