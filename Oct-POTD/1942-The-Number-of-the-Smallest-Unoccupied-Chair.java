import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        // Min heap to track leaving times and available chairs
        int nextChair = 0;
        int targetStart = times[targetFriend][0];

        // Sort the times array based on arrival times
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> leaveChair = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        // Iterate over the sorted times
        for (int[] time : times) {
            int start = time[0], leave = time[1];

            // Free up chairs for friends who have left before current start time
            while (!leaveChair.isEmpty() && leaveChair.peek()[0] <= start) {
                availableChairs.add(leaveChair.poll()[1]);
            }

            // Assign the smallest available chair or the next new chair
            int sat;
            if (!availableChairs.isEmpty()) {
                sat = availableChairs.poll();
            } else {
                sat = nextChair++;
            }

            // Add this friend's leaving time and the chair number to the leaveChair heap
            leaveChair.add(new int[]{leave, sat});

            // Return the chair number for the target friend
            if (start == targetStart) {
                return sat;
            }
        }

        return -1; // Default return (should never reach here)
    }
}