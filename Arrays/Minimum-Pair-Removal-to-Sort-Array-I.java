class Solution {
    // public int minimumPairRemoval(int[] nums) {
    //     List<Integer> list = new ArrayList<>();
    //     for (int num : nums) {
    //         list.add(num);
    //     }

    //     int operations = 0;
    //     while (list.size() > 1 && !isNonDecreasing(list)) {
    //         int minSum = Integer.MAX_VALUE;
    //         int minIndex = -1;

    //         for (int i = 0; i < list.size() - 1; i++) {
    //             int currentSum = list.get(i) + list.get(i + 1);
    //             if (currentSum < minSum) {
    //                 minSum = currentSum;
    //                 minIndex = i;
    //             }
    //         }

    //         if (minIndex != -1) {
    //             int sum = list.get(minIndex) + list.get(minIndex + 1);
    //             list.set(minIndex, sum);
    //             list.remove(minIndex + 1);
    //             operations++;
    //         } else {
    //             // This should ideally not happen if the array is not sorted and has size > 1
    //             break;
    //         }
    //     }

    //     return operations;
    // }

    // private boolean isNonDecreasing(List<Integer> nums) {
    //     for (int i = 1; i < nums.size(); i++) {
    //         if (nums.get(i) < nums.get(i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        // [5,2,3,1]-> 5 2 4-> 5 6
        
        while(list.size() != 1 && !isSorted(list)){
            int listSize = list.size();
            int pos1 = -1, pos2 = -1;
            int mini = Integer.MAX_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                int currMin = list.get(i) + list.get(i + 1);
                if (currMin < mini) {
                    mini = currMin;
                    pos1 = i;
                    pos2 = i + 1;
                }
            }
            list.set(pos1, mini);
            list.remove(pos2);
            count++;
        }
        return count;
    }
    private boolean isSorted(List<Integer> list){
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(i - 1))return false;
        }
        return true;
    }

    

}