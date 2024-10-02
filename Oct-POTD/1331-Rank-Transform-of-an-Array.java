class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> rankMap = new HashMap<>();

        for (int num : arr) {
            pq.offer(num);
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (!rankMap.containsKey(current)) {
                rankMap.put(current, rank++);
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}