class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0 , r = 0 , maxFreq = 0 , maxLen = 0;
        int[] hash = new int [26];
        while (r < s.length()) {
            /* Update frequency of current
            character in the hash array*/
            hash[s.charAt(r) - 'A']++;
            
            // Update max frequency encountered
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            
            // Check if current window is invalid
            if ((r - l + 1) - maxFreq > k) {
                /* Slide the left pointer to 
                make the window valid again*/
                hash[s.charAt(l) - 'A']--;
                
                // Move left pointer forward
                l++;
            }
            
            /* Update maxLen with the length 
            of the current valid substring*/
            maxLen = Math.max(maxLen, r - l + 1);
            
            // Move right pointer forward to expand window
            r++;
        }

        /* Return the maximum length of substring
        with at most k characters replaced*/
        return maxLen;
    
    }
}