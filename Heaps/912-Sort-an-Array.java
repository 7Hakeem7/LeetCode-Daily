class Solution {
    int[] nums;
    int[] tmp;
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        if (nums == null || nums.length == 0) {
            return nums;
        }
        this.tmp = new int[nums.length];
        mergeSort(0, nums.length-1);
        return nums;
    }

    void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }
    }

    void merge(int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int index = 0;

        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
            }
        }

        while (j <= end) {
            tmp[index++] = nums[j++];
        }

        while (i <= mid) {
            tmp[index++] = nums[i++];
        }

        for (int w = 0;w < index; w++) {
            nums[w + start] = tmp[w];
        }
    }
}