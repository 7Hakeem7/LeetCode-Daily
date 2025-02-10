import java.util.*;

class Solution {
    public String clearDigits(String s) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder currStr = new StringBuilder(s);

        // First pass: Collect indices of digits
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                q.add(i);
            }
        }

        // Second pass: Remove digits and their left characters
        int shift = 0; // Tracks how much indices shift left after deletions
        while (!q.isEmpty()) {
            int currIndex = q.poll() - shift; // Adjust index dynamically

            // Remove the left character first (only if it's not the first character)
            if (currIndex > 0) {
                currStr.deleteCharAt(currIndex - 1);
                shift++; // One deletion shifts everything left
                currIndex--; // Adjust currIndex after deletion
            }

            // Remove the digit itself
            currStr.deleteCharAt(currIndex);
            shift++; // Another deletion shifts everything left
        }

        return currStr.toString();
    }
}
