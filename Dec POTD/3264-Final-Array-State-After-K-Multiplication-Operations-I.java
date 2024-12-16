class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Priority queue for min heap, sorts by value and then by index
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            if (a.value != b.value) return (a.value - b.value);
            else return (a.index - b.index);
        });

        // Add all elements to the priority queue
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));
        }

        // Perform k operations
        while (k-- > 0) {
            // Get the minimum element
            Pair minPair = pq.poll();

            // Update the value in nums
            nums[minPair.index] *= multiplier;

            // Add the updated value back into the priority queue
            pq.offer(new Pair(nums[minPair.index], minPair.index));
        }

        return nums;
    }
}

class Pair {
    int value;
    int index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
