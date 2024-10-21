import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> uniqueSubstrings = new HashSet<>();
        return backtrack(s, 0, uniqueSubstrings);
    }

    private int backtrack(String s, int start, Set<String> uniqueSubstrings) {
        if (start == s.length()) {
            return uniqueSubstrings.size();
        }

        int maxCount = 0;

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            // Only proceed if the substring is unique
            if (!uniqueSubstrings.contains(substring)) {
                uniqueSubstrings.add(substring);
                // Recur to get the count from the next position
                maxCount = Math.max(maxCount, backtrack(s, end, uniqueSubstrings));
                // Backtrack to explore other possibilities
                uniqueSubstrings.remove(substring);
            }
        }

        return maxCount;
    }
}
