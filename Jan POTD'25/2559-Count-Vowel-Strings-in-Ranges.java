class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // Define vowels for quick lookup
        boolean[] isVowel = new boolean[26];
        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;

        int n = words.length;
        int[] prefixVowelCount = new int[n + 1];

        // Pre-traversal: Check if a string starts and ends with a vowel
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            // Increment the count if both first and last characters are vowels
            prefixVowelCount[i + 1] = prefixVowelCount[i] + (isVowel[first - 'a'] && isVowel[last - 'a'] ? 1 : 0);
        }

        // Prepare the result array
        int[] result = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];

            // Calculate the count in the range using the prefix sum
            result[i] = prefixVowelCount[ri + 1] - prefixVowelCount[li];
        }

        return result;
    }
}
