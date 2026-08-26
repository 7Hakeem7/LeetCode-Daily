class Solution {
    public void moveZeroes(int[] nums) {
        // Base case: If array is empty or has 1 element, no processing needed
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0; // Tracks the position for the next non-zero element

        // The 'right' pointer scans the array from start to end without resetting
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // Swap elements if they are at different positions
                if (left != right) {
                    swap(left, right, nums);
                }
                left++; // Advance left pointer only after placing a non-zero element
            }
        }
    }

    private void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
