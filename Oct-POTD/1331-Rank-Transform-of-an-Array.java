class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0]; // Edge case: empty array
        
        int[] sortedArr = arr.clone(); // Clone the original array
        Arrays.sort(sortedArr); // Sort the array
        
        // Map to store the rank of each unique element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        // Assign ranks to the unique elements
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        
        // Replace the elements in the original array with their ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }
}
