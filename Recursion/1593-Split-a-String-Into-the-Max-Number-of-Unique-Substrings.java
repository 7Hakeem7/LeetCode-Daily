import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return findMaxUnique(s, 0, set);
    }

    // Recursive function to find the maximum unique substrings
    private int findMaxUnique(String s, int start, HashSet<String> set) {
        if (start == s.length()) {
            return 0;  // Base case: if we have gone through the whole string
        }

        int maxCount = 0;

        // Iterate through all possible substrings starting from 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            // If substring is not in set, add it and continue recursively
            if (!set.contains(substring)) {
                set.add(substring);
                int count = 1 + findMaxUnique(s, end, set);  // Recur with the next start position
                maxCount = Math.max(maxCount, count);  // Track the maximum number of unique substrings
                set.remove(substring);  // Backtrack and remove the substring
            }
        }

        return maxCount;
    }
}
