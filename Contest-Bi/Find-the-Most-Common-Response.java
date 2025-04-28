class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        // Remove duplicates within each response[i] using HashSet
        for (int i = 0; i < responses.size(); i++) {
            HashSet<String> set = new HashSet<>();
            List<String> cleaned = new ArrayList<>();
            for (int j = 0; j < responses.get(i).size(); j++) {
                String curr = responses.get(i).get(j);
                if (!set.contains(curr)) {
                    set.add(curr);
                    cleaned.add(curr);
                }
            }
            responses.set(i, cleaned); // Update each list with unique values
        }

        // Use LinkedHashMap to preserve insertion order (if needed)
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < responses.size(); i++) {
            for (int j = 0; j < responses.get(i).size(); j++) {
                String current = responses.get(i).get(j);
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }

        // Find the max frequency string, lexicographically smallest if tied
        String maxFreqString = null;
        int maxFrequency = 0;

        for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFrequency) {
                maxFrequency = freq;
                maxFreqString = key;
            } else if (freq == maxFrequency) {
                if (maxFreqString == null || key.compareTo(maxFreqString) < 0) {
                    maxFreqString = key;
                }
            }
        }

        return maxFreqString;
    }
}
