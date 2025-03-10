class Solution {
    private boolean Vowels(char c){
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
        private long atleastK(String word, int k){
            int n = word.length();
            long substr = 0;
            int cons = 0;
            int left = 0;
            HashMap<Character, Integer> vowelCount = new HashMap<>();
            for (int right = 0; right < n; right++){
                char c = word.charAt(right);
                if (Vowels(c)){
                    vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
                } else {
                    cons++;
                }
                while (vowelCount.size() == 5 && cons >= k){
                    substr += n - right;
                    char leftChar = word.charAt(left);
                    if (Vowels(leftChar)){
                        vowelCount.put(leftChar, vowelCount.get(leftChar) -1);
                        if (vowelCount.get(leftChar) == 0){
                            vowelCount.remove(leftChar);
                        }
                    } else {
                        cons--;
                    }
                    left++;
                }
            }
            return substr;
        }
    public long countOfSubstrings(String word, int k) {
        return atleastK(word, k) - atleastK(word, k + 1);
    }
}
