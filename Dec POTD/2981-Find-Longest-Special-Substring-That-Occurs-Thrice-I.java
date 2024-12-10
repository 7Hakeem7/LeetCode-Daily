class Solution {
    public int maximumLength(String s) {
        // Take a HashMap
        // Insert only special Strings
        // Take two pointers i and j at the start
        // If the next element at j == i
        // Add the window from i -> j in the Map
        // Else i++ and j = i; and repeat the process

        // After that traverse the map for freq >= 3 and keep a track of maxCount answer
        // maxCount answer = if the currLength of special string(key) > maxCount answer
        // return the maxCount answer at the end

        HashMap<String, Integer> map = new HashMap<>();
        
        int maxCountAnswer = -1;

            for(int i = 0; i < s.length(); i++){
                StringBuilder newStr = new StringBuilder();
                for(int j = i; j<s.length(); j++){
                    if(newStr.length() == 0 || s.charAt(j) == newStr.charAt(newStr.length() - 1)){
                        newStr.append(s.charAt(j));
                        String currStr = newStr.toString();
                        map.put(currStr, map.getOrDefault(currStr, 0) + 1);
                    }
                    else{
                        break;
                    }
                }
            }
            
        // Traverse the map with freq >= 3
        for (String key : map.keySet()) {
            if (map.get(key) >= 3) { // Check if the frequency is >= 3
                int currLen = key.length(); // Get the length of the string
                if (currLen > maxCountAnswer) {
                    maxCountAnswer = currLen; // Update maxCountAnswer
                }
            }
        }
        return maxCountAnswer;
    }
}
